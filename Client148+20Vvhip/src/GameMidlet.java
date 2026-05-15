import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class GameMidlet extends MIDlet {
   public static byte CLIENT_TYPE = 1;
   public static int PORT = 14444;
   public static String IP = "";
   public static byte userProvider = 0;
   public static String clientAgent;
   public static GameMidlet instance;
   public static byte serverLogin = 0;
   public static final String VERSION = "1.8.8";
   public static final boolean NEW_VERSION = false;

   public GameMidlet() {
      instance = this;
   }

   protected void destroyApp(boolean var1) {
   }

   protected void pauseApp() {
   }

   protected void startApp() {
      UpdateServer.initMidlet(this);
      javax.microedition.lcdui.Display.getDisplay(this).setCurrent(MotherCanvas.gI());
   }
}
