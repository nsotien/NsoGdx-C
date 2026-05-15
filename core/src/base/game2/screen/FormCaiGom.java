package base.game2.screen;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;

import base.game2.CaiGom;
import base.game2.Code;
import base.game2.GameMidlet;
import base.game2.MotherCanvas;

public class FormCaiGom extends Form implements CommandListener {
   private final TextField tfName;
   private final TextField tfItemGD;
   private final TextField tfItemCat;
   private final TextField tfGio;
   private final TextField tfPhut;
   private final TextField tfMap;
   private final TextField tfZone;
   private final ChoiceGroup cgEnable;
   private final ChoiceGroup cgAutoCat;
   private final Command cmSave;

   public FormCaiGom() {
      super("Setting Gom Đồ!");
      this.tfName    = new TextField("Name nhận đồ", CaiGom.receiverName == null ? "" : CaiGom.receiverName, 32, 0);
      this.tfItemGD  = new TextField("Item GD <ID cách nhau dấu ,>", CaiGom.itemGDStr == null ? "" : CaiGom.itemGDStr, 120, 0);
      this.tfItemCat = new TextField("Item Cất <ID cách nhau dấu ,>", CaiGom.itemCatStr == null ? "" : CaiGom.itemCatStr, 120, 0);
      this.tfGio     = new TextField("Giờ nhận đồ", String.valueOf(CaiGom.gioNhan), 2, 2);
      this.tfPhut    = new TextField("Phút nhận đồ", String.valueOf(CaiGom.phutNhan), 2, 2);
      this.tfMap     = new TextField("Map nhận đồ", String.valueOf(CaiGom.mapNhan), 5, 2);
      this.tfZone    = new TextField("Khu Vực nhận", String.valueOf(CaiGom.zoneNhan), 3, 2);
      this.cgEnable  = new ChoiceGroup("Bật Auto Gom", 1, new String[]{"Bật", "Tắt"}, (Image[]) null);
      this.cgAutoCat = new ChoiceGroup("Auto cất rương khi nhận", 1, new String[]{"Bật", "Tắt"}, (Image[]) null);

      this.append(this.cgEnable);
      this.append(this.tfName);
      this.append(this.tfItemGD);
      this.append(this.tfGio);
      this.append(this.tfPhut);
      this.append(this.tfMap);
      this.append(this.tfZone);
      this.append(this.cgAutoCat);
      this.append(this.tfItemCat);

      this.cgEnable.setSelectedIndex(CaiGom.enabled ? 0 : 1, true);
      this.cgAutoCat.setSelectedIndex(CaiGom.autoCat ? 0 : 1, true);

      this.cmSave = new Command("Lưu", 4, 0);
      this.addCommand(this.cmSave);
      this.addCommand(new Command("Thoát", 7, 0));
      this.setCommandListener(this);
   }

   public void a() {
      Display.getDisplay(GameMidlet.g).setCurrent(this);
   }

   public void commandAction(Command c, Displayable d) {
      if (c == this.cmSave) {
         try {
            CaiGom.enabled       = this.cgEnable.isSelected(0);
            CaiGom.autoCat       = this.cgAutoCat.isSelected(0);
            CaiGom.receiverName  = this.tfName.getString();
            CaiGom.itemGDStr     = this.tfItemGD.getString();
            CaiGom.itemCatStr    = this.tfItemCat.getString();
            CaiGom.gioNhan       = Integer.parseInt(this.tfGio.getString());
            CaiGom.phutNhan      = Integer.parseInt(this.tfPhut.getString());
            CaiGom.mapNhan       = Integer.parseInt(this.tfMap.getString());
            CaiGom.zoneNhan      = Integer.parseInt(this.tfZone.getString());
            CaiGom.gomCC = -1;
            CaiGom.save();
            Code.popup_chat("Lưu cài đặt thành công");
         } catch (Exception e) {
            Code.popup_chat("Lỗi: kiểm tra lại cài đặt!");
         }
      }
      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }
}
