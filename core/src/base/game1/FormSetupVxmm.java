package base.game1;

import javax.microedition.lcdui.*;

public final class FormSetupVxmm extends Form implements CommandListener {
   private final TextField xuMin;
   private final TextField xuMax;

   private final Command advAH;

   public FormSetupVxmm() {
      super("Cài xu đặt vxmm");
      this.append(this.xuMin = new TextField("Xu min", String.valueOf(Code.xuMin), 10, 2));
      this.append(this.xuMax = new TextField("Xu max", String.valueOf(Code.xuMax), 10, 2));
      this.addCommand(this.advAH = new Command("Save", 4, 0));
      this.addCommand(new Command("Cancel", 7, 0));
      this.setCommandListener(this);
   }

   public final void advAA() {
      Display.getDisplay(GameMidlet.g).setCurrent(this);
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1 == this.advAH) {
         try {
            Code.xuMin = Integer.parseInt(this.xuMin.getString());
            Code.xuMax = Integer.parseInt(this.xuMax.getString());
            Code.popup_chat("Lưu cài đặt xu VXMM thành công");
         } catch (Exception var10) {
            Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Lỗi", "Có lỗi xảy ra. Hãy xem lại cài đặt!", null, AlertType.ERROR));
            return;
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }
}
