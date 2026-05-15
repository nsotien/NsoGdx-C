package base.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public final class ChatOverlayMobile {
   private static ChatOverlayMobile instance;
   private boolean dialogOpen;
   private long lastSendAt;

   private ChatOverlayMobile() {
   }

   public static ChatOverlayMobile gI() {
      return instance == null ? (instance = new ChatOverlayMobile()) : instance;
   }

   public void openInput(GameScr var1, String var2, int var3) {
      if (!this.dialogOpen && ChatTextField.canOpenChat()) {
         final GameScr var4 = var1 != null ? var1 : GameScr.instance;
         if (var4 != null) {
            this.dialogOpen = true;
            ChatTextField.a().b = true;
            final String var5 = var2 == null ? TextGame.oi[0] : var2;
            String var6 = "Chat - " + var5;
            final String var7 = initialText(var3);
            if (DebugLog.DEBUG) {
               DebugLog.log("UI-CHAT", "Mobile open tab=" + var5);
            }

            Gdx.app.postRunnable(new Runnable() {
               public void run() {
                  Gdx.input.getTextInput(new Input.TextInputListener() {
                     public void input(String var1x) {
                        ChatOverlayMobile.this.dialogOpen = false;
                        ChatTextField.a().b = false;
                        long var2x = System.currentTimeMillis();
                        if (var2x - ChatOverlayMobile.this.lastSendAt >= 1000L) {
                           String var4x = var1x == null ? "" : var1x.trim();
                           if (!var4x.equals("")) {
                              ChatOverlayMobile.this.lastSendAt = var2x;
                              var4.a(var4x, var5);
                              if (DebugLog.DEBUG) {
                                 DebugLog.log("UI-CHAT", "Mobile send tab=" + var5 + " text=" + var4x);
                              }
                           }
                        }
                     }

                     public void canceled() {
                        ChatOverlayMobile.this.dialogOpen = false;
                        ChatTextField.a().b = false;
                        if (DebugLog.DEBUG) {
                           DebugLog.log("UI-CHAT", "Mobile cancel");
                        }
                     }
                  }, var6, var7, "");
               }
            });
         }
      }
   }

   public void openInput(GameScr var1, String var2) {
      this.openInput(var1, var2, 0);
   }

   public boolean isDialogOpen() {
      return this.dialogOpen;
   }

   private static String initialText(int var0) {
      if (var0 >= 32 && var0 <= 126) {
         return String.valueOf((char)var0);
      } else {
         return var0 > 160 ? String.valueOf((char)var0) : "";
      }
   }
}
