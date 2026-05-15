package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.microedition.lcdui.Image;

public final class Item {
   public int indexFrame;
   public ItemTemplate template;
   public MyVector options;
   public int itemId;
   private int playerId;
   public int indexUI;
   public int quantity;
   public long expires;
   public boolean isLock;
   public int sys;
   public int upgrade;
   public int buyCoin;
   public int buyCoinLock;
   public int buyGold;
   private int buyGoldLock;
   public int saleCoinLock;
   public int typeUI;
   public boolean advAV = false;
   public boolean advAS = false;
   public long advAU = 0L;
   public long advAT = 0L;
   public boolean isExpires;
   public EffectCharPaint eff;
   public int indexEff;
   public Image img;
   public boolean w_tl = false;
   public int x_tl = 0;
   public long y_tl = 0L;

   public final Item a() {
      Item var1;
      (var1 = new Item()).template = this.template;
      if (this.options != null) {
         var1.options = new MyVector();

         for(int var2 = 0; var2 < this.options.size(); ++var2) {
            ItemOption var3;
            (var3 = new ItemOption()).c = ((ItemOption)this.options.elementAt(var2)).c;
            var3.a = ((ItemOption)this.options.elementAt(var2)).a;
            var1.options.addElement(var3);
         }
      }

      var1.itemId = this.itemId;
      var1.playerId = this.playerId;
      var1.indexUI = this.indexUI;
      var1.quantity = this.quantity;
      var1.expires = this.expires;
      var1.isLock = this.isLock;
      var1.sys = this.sys;
      var1.upgrade = this.upgrade;
      var1.buyCoin = this.buyCoin;
      var1.buyCoinLock = this.buyCoinLock;
      var1.buyGold = this.buyGold;
      var1.buyGoldLock = this.buyGoldLock;
      var1.saleCoinLock = this.saleCoinLock;
      var1.typeUI = this.typeUI;
      var1.isExpires = this.isExpires;
      return var1;
   }

   public final Item a(int var1) {
      Item var4;
      (var4 = this.a()).isLock = true;
      int var2;
      if ((var2 = var1 - var4.upgrade) == 0) {
         return var4;
      } else {
         var4.upgrade = var1;
         if (var4.options != null) {
            for(var1 = 0; var1 < var4.options.size(); ++var1) {
               ItemOption var3;
               if ((var3 = (ItemOption)var4.options.elementAt(var1)).c.a != 6 && var3.c.a != 7) {
                  if (var3.c.a != 8 && var3.c.a != 9 && var3.c.a != 19) {
                     if (var3.c.a != 10 && var3.c.a != 11 && var3.c.a != 12 && var3.c.a != 13 && var3.c.a != 14 && var3.c.a != 15 && var3.c.a != 17 && var3.c.a != 18 && var3.c.a != 20) {
                        if (var3.c.a != 21 && var3.c.a != 22 && var3.c.a != 23 && var3.c.a != 24 && var3.c.a != 25 && var3.c.a != 26) {
                           if (var3.c.a == 16) {
                              var3.a += var2 * 3;
                           }
                        } else {
                           var3.a += var2 * 150;
                        }
                     } else {
                        var3.a += var2 * 5;
                     }
                  } else {
                     var3.a += var2 * 10;
                  }
               } else {
                  var3.a += var2 * 15;
               }
            }
         }

         return var4;
      }
   }

   public final boolean b() {
      return this.template.type >= 0 && this.template.type <= 15;
   }

   public final boolean c() {
      return 29 <= this.template.type && this.template.type <= 33;
   }

   public final boolean d() {
      return this.template.type == 34;
   }

   public final String e() {
      if (this.expires <= 0L) {
         return TextGame.ek;
      } else {
         Calendar var1;
         (var1 = Calendar.getInstance()).setTimeZone(TimeZone.getTimeZone("GMT+7"));
         var1.setTime(new Date(this.expires));
         int var5 = var1.get(11);
         int var2 = var1.get(12);
         int var3 = var1.get(5);
         int var4 = var1.get(2) + 1;
         int var6 = var1.get(1);
         return var3 + "/" + var4 + "/" + var6 + " " + var5 + "h" + var2 + "'";
      }
   }

   public final String f() {
      if (this.expires <= 0L) {
         return TextGame.ek;
      } else if (this.expires / 1000L >= 2592000L) {
         return this.expires / 1000L / 2592000L + " " + TextGame.ku;
      } else if (this.expires / 1000L >= 604800L) {
         return this.expires / 1000L / 604800L + " " + TextGame.kv;
      } else if (this.expires / 1000L >= 86400L) {
         return this.expires / 1000L / 86400L + " " + TextGame.kw;
      } else if (this.expires / 1000L >= 3600L) {
         return this.expires / 1000L / 3600L + " " + TextGame.kx;
      } else {
         return this.expires / 1000L >= 60L ? this.expires / 1000L / 60L + " " + TextGame.kz : "";
      }
   }

   public final void g() {
      if (!this.c()) {
         this.expires = 0L;
      }

   }

   public final boolean h() {
      return this.typeUI == 5 || this.typeUI == 3 || this.typeUI == 4 || this.typeUI == 39;
   }

   public final boolean i() {
      if (this.j()) {
         return true;
      } else {
         return this.l() || this.m() || this.n() || this.o();
      }
   }

   public final boolean j() {
      return this.typeUI == 20 || this.typeUI == 21 || this.typeUI == 22 || this.typeUI == 23 || this.typeUI == 24 || this.typeUI == 25 || this.typeUI == 26 || this.typeUI == 27 || this.typeUI == 28 || this.typeUI == 29 || this.typeUI == 16 || this.typeUI == 17 || this.typeUI == 18 || this.typeUI == 19 || this.typeUI == 2 || this.typeUI == 6 || this.typeUI == 8 || this.typeUI == 34;
   }

   public final boolean k() {
      return this.typeUI == 7 || this.typeUI == 9;
   }

   public final boolean l() {
      return this.typeUI == 14;
   }

   public final boolean m() {
      return this.typeUI == 15;
   }

   public final boolean n() {
      return this.typeUI == 32;
   }

   public final boolean o() {
      return this.typeUI == 34;
   }

   public final boolean p() {
      return this.q() == this.upgrade;
   }

   public final int q() {
      if (this.template.level >= 1 && this.template.level < 20) {
         return 4;
      } else if (this.template.level >= 20 && this.template.level < 40) {
         return 8;
      } else if (this.template.level >= 40 && this.template.level < 50) {
         return 12;
      } else {
         return this.template.level >= 50 && this.template.level < 60 ? 14 : 16;
      }
   }

   public final boolean r() {
      return this.template.type == 0 || this.template.type == 2 || this.template.type == 4 || this.template.type == 6 || this.template.type == 8;
   }

   public final boolean s() {
      return this.template.type == 3 || this.template.type == 5 || this.template.type == 7 || this.template.type == 9;
   }

   public final boolean t() {
      return this.template.type == 1;
   }

   public final int lvTL() {
      if (this.options != null) {
         for(int var1 = 0; var1 < this.options.size(); ++var1) {
            if (((ItemOption)this.options.elementAt(var1)).c.a == 85) {
               return ((ItemOption)this.options.elementAt(var1)).a;
            }
         }
      }

      return -1;
   }

   public final boolean u() {
      if (this.options != null) {
         for(int var1 = 0; var1 < this.options.size(); ++var1) {
            if (((ItemOption)this.options.elementAt(var1)).c.a == 155) {
               return true;
            }
         }
      }

      return false;
   }

   // --- DV port: check if item has option with specific ID ---
   public final boolean advAB(int optionId) {
      if (this.options != null) {
         for (int i = 0; i < this.options.size(); ++i) {
            if (((ItemOption) this.options.elementAt(i)).c.a == optionId) {
               return true;
            }
         }
      }
      return false;
   }

   // --- DV port: count options of specific type ---
   public final int advAC(int optionType) {
      int count = 0;
      if (this.options != null) {
         for (int i = 0; i < this.options.size(); ++i) {
            if (((ItemOption) this.options.elementAt(i)).c.c == optionType) {
               ++count;
            }
         }
      }
      return count;
   }

}
