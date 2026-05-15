package base.game2;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ChatTextField implements IActionListener {
   private static ChatTextField g;
   public TField a;
   public boolean b = false;
   GameScr c;
   private long h = 0L;
   public Command1 d;
   public Command1 e;
   public Command1 f;
   public String i;

   public static ChatTextField a() {
      return g == null ? (g = new ChatTextField()) : g;
   }

   protected ChatTextField() {
      this.d = new Command1(TextGame.bw, this, 8000, (Object)null, 1, GameCanvas.ab - mScreen.f + 1);
      this.e = new Command1(TextGame.ah, this, 8001, (Object)null, GameCanvas.aa - 53, GameCanvas.ab - mScreen.f + 1);
      this.f = null;
      this.a = new TField();
      this.a.k = "chat";
      this.a.a = 16;
      this.a.c = MotherCanvas.a.b() - 32;
      this.a.d = mScreen.d + 2;
      this.a.e = true;
      this.a.b(40);
      this.updateCommandPositions();
   }

   public final void a(int var1, GameScr var2, String var3) {
      this.updateCommandPositions();
      this.e.a = TextGame.ah;
      this.i = var3;
      if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
         this.a.e(var1);
         if (!this.a.d().equals("") && GameCanvas.aj == null) {
            this.c = var2;
            this.b = true;
         }
      } else {
         this.c = var2 != null ? var2 : GameScr.instance;
         if (GameCanvas.aj == null && canOpenChat()) {
            ChatOverlayMobile.gI().openInput(this.c, var3, var1);
         } else {
            this.b = false;
         }
      }

      this.a.g = var3;
   }

   public final void a(String var1) {
      this.updateCommandPositions();
      this.e.a = TextGame.ah;
      this.i = var1;
      if (GameScr.instance != null) {
         this.c = GameScr.instance;
      }

      if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
         if (GameCanvas.aj == null) {
            this.b = true;
         }
      } else {
         if (GameCanvas.aj == null && canOpenChat()) {
            ChatOverlayMobile.gI().openInput(this.c, var1);
         } else {
            this.b = false;
         }
      }

      this.a.g = var1;
   }

   public final void a(mGraphics var1) {
      this.updateCommandPositions();
      if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
         if (this.b) {
            this.a.a(var1);
         }
      } else if (!ChatOverlayMobile.gI().isDialogOpen()) {
         this.b = false;
      }

   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 8000:
            if (this.c != null) {
               long var3;
               if ((var3 = System.currentTimeMillis()) - this.h < 1000L) {
                  return;
               }

               this.h = var3;
               this.c.a(this.a.d(), this.i);
               this.a.a("");
               this.e.a = TextGame.ah;
               this.b = GameScr.cu;
               this.a.e = this.b;
               return;
            }
            break;
         case 8001:
            this.a.a("");
            this.b = false;
            this.a.e = false;
            this.e.a = TextGame.ah;
      }

   }

   private void updateCommandPositions() {
      int var1 = GameCanvas.ab - mScreen.f + 1;
      int var2 = mGraphics.a(GameScr.ea);
      if (var2 <= 0) {
         var2 = mScreen.e;
      }

      this.d.f = 1;
      this.d.g = var1;
      this.e.f = GameCanvas.aa - var2 - 1;
      this.e.g = var1;
   }

   public static boolean canOpenChat() {
      return GameCanvas.currentScreen == GameScr.instance && Char.getMyChar() != null;
   }

}
