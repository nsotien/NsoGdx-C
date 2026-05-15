package base.game1;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;

public class SettingGKN extends Form implements CommandListener {
   private ChoiceGroup cgBat;
   private ChoiceGroup cgMode;
   private Command cmdLuu;

   public SettingGKN() {
      super("Auto Giữ Kết Nối");
      this.append(this.cgBat = new ChoiceGroup("Bật", 1, new String[]{"Bật", "Tắt"}, (Image[])null));
      this.append(this.cgMode = new ChoiceGroup("Chế độ", 1, new String[]{"Tại chỗ", "Sang map (riêng sv kunai)"}, (Image[])null));
      this.addCommand(this.cmdLuu = new Command("Lưu", 4, 0));
      this.addCommand(new Command("Thoát", 7, 0));
      this.setCommandListener(this);
      // Hiện trạng thái hiện tại
      this.cgBat.setSelectedIndex(Code.giuKetNoi ? 0 : 1, true);
      this.cgMode.setSelectedIndex(Code.giuKetNoiMode, true);
   }

   public void commandAction(Command cmd, Displayable d) {
      if (cmd == this.cmdLuu) {
         int bat = this.cgBat.getSelectedIndex();
         int mode = this.cgMode.getSelectedIndex();

         if (bat == 1) {
            // Tắt
            if (Code.giuKetNoi) {
               Code.giuKetNoi = false;
               Code.popup_chat("Tắt auto giữ kết nối");
               Code.gknLog("[GKN] === TẮT ===");
            }
         } else {
            // Bật — mutual exclusion: tắt tàn sát nếu đang chạy
            if (Code.mode instanceof AutoTansat) {
               Code.popup_chat("Tắt tàn sát");
               Code.mode = null;
               Code.gknLog("[GKN] Tắt tàn sát (mutual exclusion)");
            }
            Code.giuKetNoi = true;
            Code.giuKetNoiMode = mode;
            // Reset timers
            Code.lastSelectSkillKA = 0L;
            Code.lastAttackKA = 0L;
            Code.lastGknKeepAlive = System.currentTimeMillis();
            String modeName = mode == 0 ? "tại chỗ" : "sang map";
            Code.popup_chat("Bật auto giữ kết nối (" + modeName + ")");
            Code.gknLog("[GKN] === BẬT === mode=" + modeName + " mapID=" + TileMap.mapID + " pos=(" + Char.getMyChar().cx1 + "," + Char.getMyChar().cy1 + ")");
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }
}
