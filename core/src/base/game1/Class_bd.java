package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.TextBox;

final class Class_bd implements CommandListener {
   private TField a;
   private final TextBox b;

   Class_bd(TField var1, TextBox var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1.getLabel().equals(TextGame.bx)) {
         this.a.a(this.b.getString());
      }

      Display.getDisplay(TField.j).setCurrent(TField.i);
      TField.i.setFullScreenMode(true);
      this.a.ij = true;
   }

}
