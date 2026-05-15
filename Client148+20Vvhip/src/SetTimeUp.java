import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public final class SetTimeUp extends Form implements CommandListener {
   private TextField gameAA;
   private TextField gameAB;
   private TextField gameAC;
   private javax.microedition.lcdui.Command gameAD;
   private static SetTimeUp gameAE;

   public SetTimeUp() {
      super("Cài up time - Cài all 0 để up full time");
      this.append(this.gameAA = new TextField("Ngày up", "", 3, 2));
      this.append(this.gameAB = new TextField("Giờ up", "", 3, 2));
      this.append(this.gameAC = new TextField("Phút up", "", 3, 2));
      this.addCommand(this.gameAD = new javax.microedition.lcdui.Command("Lưu", 4, 0));
      this.addCommand(new javax.microedition.lcdui.Command("Thoát", 7, 0));
      this.setCommandListener(this);
   }

   public static SetTimeUp gameAA() {
      if (gameAE == null) {
         gameAE = new SetTimeUp();
      }

      return gameAE;
   }

   public final void gameAB() {
      long var1 = Code.gameBD / 60000L;
      this.gameAC.setString(String.valueOf(var1 % 60L));
      var1 /= 60L;
      this.gameAB.setString(String.valueOf(var1 % 60L));
      var1 /= 60L;
      this.gameAA.setString(String.valueOf(var1));
      Display.getDisplay(GameMidlet.instance).setCurrent(this);
   }

   public final void commandAction(javax.microedition.lcdui.Command var1, Displayable var2) {
      if (var1 == this.gameAD) {
         int var5 = 0;
         int var6 = 0;
         int var3 = 0;

         try {
            var5 = Integer.parseInt(this.gameAA.getString());
            var6 = Integer.parseInt(this.gameAB.getString());
            var3 = Integer.parseInt(this.gameAC.getString());
         } catch (Exception var4) {
         }

         Code.gameBD = ((long)(var5 * 24 + var6) * 60L + (long)var3) * 60L * 1000L;
      }

      Display.getDisplay(GameMidlet.instance).setCurrent(MotherCanvas.instance);
      MotherCanvas.instance.setFullScreenMode(true);
   }
}
