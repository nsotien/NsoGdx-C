package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class ChatManager {
   public MyVector a = new MyVector();
   private static ChatManager h;
   public int b = 0;
   public static boolean c;
   public static boolean d;
   public static boolean e;
   public static boolean f;
   public static boolean blockPublic;
   public static boolean blockNotify;
   public static boolean hideIngameName;
   public MyVector g = new MyVector();

   public static String hideAuthor(String name) {
      Char my = Char.getMyChar();
      return (hideIngameName && my != null && name != null && name.equals(my.cName)) ? "nsotientv" : name;
   }

   // Port TGAME: chặn thông báo EXP/Yên/item nhận được khi blockNotify = true
   public static void showNotify(String text) {
      if (!blockNotify) {
         InfoMe.a(text);
      }
   }

   public static void showNotify(String text, int time, mFont font) {
      if (!blockNotify) {
         InfoMe.a(text, time, font);
      }
   }

   public static boolean shouldBlockNotify(String text) {
      return blockNotify;
   }

   public static boolean isBlockAll() {
      return c && d && blockNotify && blockPublic;
   }

   public static void setBlockAll(boolean value) {
      c = value;
      d = value;
      blockNotify = value;
      blockPublic = value;
   }

   public final void a() {
      ++this.b;
      if (this.b > this.a.size() - 1) {
         this.b = 0;
      }

   }

   public final void b() {
      --this.b;
      if (this.b < 0) {
         this.b = this.a.size() - 1;
      }

   }

   public final void a(int var1) {
      this.b = var1;
   }

   public final void a(ChatTab var1) {
      this.b = this.a.indexOf(var1);
   }

   public final void c() {
      this.b = this.a.size() - 1;
   }

   public static ChatManager d() {
      return h == null ? (h = new ChatManager()) : h;
   }

   public ChatManager() {
      this.a.addElement(new ChatTab(TextGame.oi[0], 0));
      this.a.addElement(new ChatTab(TextGame.oj[0], 1));
      this.a.addElement(new ChatTab(TextGame.ok[0], 3));
      this.a.addElement(new ChatTab(TextGame.ol[0], 4));
      ChatTab var1;
      (var1 = this.a(TextGame.ok[0])).a("c8" + TextGame.ok[1]);
      var1.a("c8" + TextGame.ok[2]);
      var1.a("c8" + TextGame.ok[3]);
      this.a(TextGame.oj[0]).a("c8" + TextGame.oj[1]);
      this.a(TextGame.ol[0]).a("c8" + TextGame.ol[1]);
      this.a(TextGame.oi[0]).a("c8" + TextGame.oi[1]);
   }

   public final ChatTab a(String var1) {
      for(int var2 = 0; var2 < this.a.size(); ++var2) {
         ChatTab var3;
         if ((var3 = (ChatTab)this.a.elementAt(var2)).b.equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   public final void a(String var1, String var2, String var3) {
      ChatTab var4;
      if ((var4 = this.a(var1)) == null) {
         var4 = this.b(var1);
      }

      var4.a(var2, var3);
   }

   public final ChatTab e() {
      return (ChatTab)this.a.elementAt(this.b);
   }

   public final ChatTab b(String var1) {
      ChatTab var2 = new ChatTab(var1, 2);
      if (!GameCanvas.g) {
         var2.a("c2" + TextGame.oh);
      }

      this.a.addElement(var2);
      return var2;
   }

   public final void c(String var1) {
      for(int var2 = 0; var2 < this.g.size(); ++var2) {
         if (((String)this.g.elementAt(var2)).equals(var1)) {
            return;
         }
      }

      this.g.addElement(var1);
   }

   public final boolean d(String var1) {
      for(int var2 = 0; var2 < this.g.size(); ++var2) {
         if (((String)this.g.elementAt(var2)).equals(var1)) {
            return true;
         }
      }

      return false;
   }

   public final void e(String var1) {
      for(int var2 = 0; var2 < this.g.size(); ++var2) {
         if (((String)this.g.elementAt(var2)).equals(var1)) {
            this.g.removeElementAt(var2);
            return;
         }
      }

   }

   public static void f() {
      h = null;
   }

}
