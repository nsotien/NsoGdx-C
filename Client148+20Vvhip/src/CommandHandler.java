import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

public final class CommandHandler implements CommandListener {
   private TField gameAA;
   private final TextBox gameAB;

   public CommandHandler(TField var1, TextBox var2) {
      this.gameAA = var1;
      this.gameAB = var2;
   }

   public final void commandAction(javax.microedition.lcdui.Command var1, Displayable var2) {
      if (var1.getLabel().equals(mResources.OK)) {
         this.gameAA.gameAA(this.gameAB.getString());
      }

      Display.getDisplay(GameMidlet.instance).setCurrent(MotherCanvas.instance);
      MotherCanvas.instance.setFullScreenMode(true);
      this.gameAA.gameAI = true;
   }
}
