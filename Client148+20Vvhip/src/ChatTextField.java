public final class ChatTextField implements IActionListener {
   private static ChatTextField instance;
   public TField tfChat;
   public boolean isShow = false;
   public IChatable parentScreen;
   private long lastChatTime = 0L;
   public Command left;
   public Command right;
   public Command gameAF;
   public String to;

   public static ChatTextField gameAA() {
      return instance == null ? (instance = new ChatTextField()) : instance;
   }

   protected ChatTextField() {
      this.left = new Command(mResources.CHAT, this, 8000, 1, GameCanvas.h - mScreen.cmdH + 1);
      this.right = new Command(mResources.DELETE, this, 8001, GameCanvas.w - 53, GameCanvas.h - mScreen.cmdH + 1);
      this.gameAF = null;
      this.tfChat = new TField();
      this.tfChat.name = "chat";
      this.tfChat.x = 16;
      this.tfChat.width = MotherCanvas.instance.gameAC() - 32;
      this.tfChat.height = mScreen.ITEM_HEIGHT + 2;
      this.tfChat.isFocus = true;
      this.tfChat.gameAB(40);
   }

   public final void gameAA(int var1, IChatable var2, String var3) {
      this.right.caption = mResources.CLOSE;
      this.to = var3;
      this.tfChat.gameAA(var1);
      if (!this.tfChat.gameAD().equals("") && GameCanvas.currentDialog == null) {
         this.parentScreen = var2;
         this.isShow = true;
      }

      this.tfChat.title_Null = var3;
   }

   public final void gameAA(String var1) {
      this.right.caption = mResources.CLOSE;
      this.to = var1;
      if (GameCanvas.currentDialog == null) {
         this.isShow = true;
         if (GameCanvas.isTouch) {
            this.tfChat.gameAA();
         }
      }

      this.tfChat.title_Null = var1;
   }

   public final void gameAA(mGraphics var1) {
      if (this.isShow) {
         this.tfChat.gameAA(var1);
      }

   }

   public final void perform(int var1, Object var2) {
      switch(var1) {
      case 8000:
         if (this.parentScreen != null) {
            long var3;
            if ((var3 = System.currentTimeMillis()) - this.lastChatTime < 1000L) {
               return;
            }

            this.lastChatTime = var3;
            this.parentScreen.onChatFromMe(this.tfChat.gameAD(), this.to);
            this.tfChat.gameAA("");
            this.right.caption = mResources.CLOSE;
            return;
         }
         break;
      case 8001:
         this.tfChat.gameAB();
         if (this.tfChat.gameAD().equals("")) {
            this.isShow = false;
            this.parentScreen.onCancelChat();
         }
      }

   }
}
