package base.game1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;

public class KichYen extends Form implements CommandListener {
   public static boolean isMobThuong = true;
   public static boolean isMobTinhAnh = true;
   public static boolean isMobThuLinh = true;
   public static boolean active = false;
   public static int hpMobNomal = 60;
   public static int hpMobTa = 60;
   public static int hpMobTL = 60;
   private Command save;
   private ChoiceGroup loaiquai;
   private ChoiceGroup kichyen;
   private TextField hpNomal;
   private TextField hpTinhAnh;
   private TextField hpThuLinh;
   private static int[] j;

   public KichYen() {
      super("Menu kích yên");
      this.append(this.kichyen = new ChoiceGroup("Kích yên", 1, new String[]{"Bật", "Tắt"}, (Image[])null));
      this.append(this.loaiquai = new ChoiceGroup("Loại quái", 2, new String[]{"Thường", "Tinh anh", "Thủ lĩnh"}, (Image[])null));
      this.append(this.hpNomal = new TextField("HP quái thường (% máu)", String.valueOf(hpMobNomal), 3, 2));
      this.append(this.hpTinhAnh = new TextField("HP tinh anh (% máu)", String.valueOf(hpMobTa), 3, 2));
      this.append(this.hpThuLinh = new TextField("HP thủ lĩnh (% máu)", String.valueOf(hpMobTL), 3, 2));
      this.addCommand(this.save = new Command("Save", 4, 244));
      this.addCommand(new Command("Cancel", 7, 244));
      this.setCommandListener(this);
      ChoiceGroup var10000 = this.kichyen;
      byte selected;
      if (active) {
         selected = 0;
      } else {
         selected = 1;
      }

      var10000.setSelectedIndex(selected, true);
      this.loaiquai.setSelectedIndex(0, isMobThuong);
      this.loaiquai.setSelectedIndex(1, isMobTinhAnh);
      this.loaiquai.setSelectedIndex(2, isMobThuLinh);
   }

   static void loadKichYen() {
      byte[] var0 = RMS.a("Nsotien_kichyen");
      if (var0 != null) {
         ByteArrayInputStream var1 = new ByteArrayInputStream(var0);
         DataInputStream var2 = new DataInputStream(var1);

         try {
            active = var2.readBoolean();
            isMobThuong = var2.readBoolean();
            isMobTinhAnh = var2.readBoolean();
            isMobThuLinh = var2.readBoolean();
            hpMobNomal = var2.readInt();
            hpMobTa = var2.readInt();
            hpMobTL = var2.readInt();
            var2.close();
            var1.close();
         } catch (Exception var4) {
         }
      }

   }

   public void commandAction(Command var1, Displayable var2) {
      if (var1 == this.save) {
         ByteArrayOutputStream var3 = new ByteArrayOutputStream();
         DataOutputStream var4 = new DataOutputStream(var3);

         try {
            boolean var10000 = this.kichyen.getSelectedIndex() == 0;
            active = var10000;
            isMobThuong = this.loaiquai.isSelected(0);
            isMobTinhAnh = this.loaiquai.isSelected(1);
            isMobThuLinh = this.loaiquai.isSelected(2);
            hpMobNomal = Integer.parseInt(this.hpNomal.getString());
            hpMobTa = Integer.parseInt(this.hpTinhAnh.getString());
            hpMobTL = Integer.parseInt(this.hpThuLinh.getString());
            var4.writeBoolean(active);
            var4.writeBoolean(isMobThuong);
            var4.writeBoolean(isMobTinhAnh);
            var4.writeBoolean(isMobThuLinh);
            var4.writeInt(hpMobNomal);
            var4.writeInt(hpMobTa);
            var4.writeInt(hpMobTL);
            RMS.a("Nsotien_kichyen", var3.toByteArray());
            var4.flush();
            var3.flush();
            Code.popup_chat("Lưu cài đặt thành công");
         } catch (Exception var6) {
            ;
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }

   public static boolean checkMob(Mob var0) {
      if (var0 != null && active) {
         if (var0.levelBoss == 0 && isMobThuong && (double)var0.hp <= (double)var0.maxHp * ((double)hpMobNomal / 100.0)) {
            return true;
         }

         if (var0.levelBoss == 1 && isMobTinhAnh && (double)var0.hp <= (double)var0.maxHp * ((double)hpMobTa / 100.0)) {
            return true;
         }

         if (var0.levelBoss == 2 && isMobThuLinh && (double)var0.hp <= (double)var0.maxHp * ((double)hpMobTL / 100.0)) {
            return true;
         }
      }

      return false;
   }

   private static void b() {
      j = new int[8];
      j[0] = 20000;
      j[1] = 1;
      j[2] = 2;
      j[3] = 244;
      j[4] = 3;
      j[5] = 9;
      j[6] = 4;
      j[7] = 107;
   }
}
