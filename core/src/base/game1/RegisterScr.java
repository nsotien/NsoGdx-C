package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class RegisterScr extends mScreen implements IActionListener {
   public static RegisterScr h;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;
   private TField[] q = new TField[7];
   private String[] r = new String[]{"Họ và tên", "Ngày-tháng-năm sinh", "Địa chỉ thường trú", "CMND", "Ngày cấp(dd-mm-yyyy)", "Nơi cấp", "Số điện thoại, địa chỉ thư điện tử (nếu có).", "* Dưới 18 tuổi chỉ có thể chơi 180p 1 ngày"};
   private String[] s = new String[]{"", "", "", "", "", "", "", ""};
   public Scroll i = new Scroll();

   public RegisterScr() {
      h = this;
      this.j = GameCanvas.ac - 100;
      this.k = 10;
      this.l = 200;
      this.m = GameCanvas.ab - 40;
      this.n = this.l - 40;
      this.o = GameCanvas.ac - this.n / 2;

      for(int var1 = 0; var1 < this.q.length; ++var1) {
         this.q[var1] = new TField();
         this.q[var1].k = this.r[var1];
         this.q[var1].a = this.o;
         this.q[var1].b = (var1 + 1) * 50;
         this.q[var1].c = this.n;
         this.q[var1].d = mScreen.d + 2;
         this.q[var1].e = false;
         this.q[var1].c(3);
         this.q[var1].a(this.s[var1]);
         if (var1 == 0) {
            this.q[var1].e = true;
         }
      }

      super.a = new Command1(TextGame.ci, this, 1, (Object)null);
   }

   public final void d() {
      super.d();
      if (++GameScr.p > GameCanvas.aa * 3 + 100) {
         GameScr.p = 100;
      }

      int var1;
      for(var1 = 0; var1 < this.q.length; ++var1) {
         this.q[var1].c();
      }

      new ScrollResult();
      ScrollResult var2 = null;
      if ((var2 = this.i.b()).a || var2.c) {
         this.p = (byte)var2.b;
      }

      this.i.c();
      var2.getClass();
      if (this.p == -1) {
         for(var1 = 0; var1 < this.q.length; ++var1) {
            this.q[var1].e = false;
         }
      }

   }

   public final void a(int var1) {
      super.a(var1);

      for(int var2 = 0; var2 < this.q.length; ++var2) {
         if (this.q[var2].e) {
            this.q[var2].a(var1);
         }
      }

   }

   public final void e() {
      if (GameCanvas.n[2]) {
         --this.p;
         if (this.p < 0) {
            this.p = this.r.length;
         }

         this.i.a(this.p * this.i.h);
      } else if (GameCanvas.n[8]) {
         ++this.p;
         if (this.p > this.r.length) {
            this.p = 0;
         }

         this.i.a(this.p * this.i.h);
      }

      int var1;
      if (GameCanvas.n[2] || GameCanvas.n[8]) {
         GameCanvas.h();

         for(var1 = 0; var1 < this.q.length; ++var1) {
            this.q[var1].e = false;
         }

         if (this.p < this.q.length) {
            this.q[this.p].e = true;
         }

         this.i.a(this.p * this.i.h);
      }

      if (GameCanvas.b(this.j, this.k, this.l, this.m) && GameCanvas.r) {
         for(var1 = 0; var1 < this.q.length; ++var1) {
            if (GameCanvas.b(this.q[var1].a, this.q[var1].b, this.q[var1].c, this.q[var1].d)) {
               this.p = var1;
            }
         }
      }

      super.e();
      GameCanvas.h();
   }

   public final void a(mGraphics var1) {
      var1.a(0);
      var1.c(0, 0, GameCanvas.aa, GameCanvas.ab);
      GameCanvas.a(var1);
      Paint.a(this.j, this.k, this.l, this.m, var1);
      mFont.e.a(var1, TextGame.ci, GameCanvas.ac, this.k + 10, 2);
      this.i.a(this.r.length, 50, this.j, this.k + 25, this.l, this.m - 25, true, 0);
      this.i.a(var1, this.j, this.k + 25, this.l, this.m - 25);

      int var2;
      for(var2 = 0; var2 < this.r.length; ++var2) {
         if (var2 != this.r.length - 1) {
            mFont.j.a(var1, this.r[var2], GameCanvas.ac, (var2 + 1) * 50 - 13, 2);
         } else {
            mFont.l.a(var1, this.r[var2], GameCanvas.ac, (var2 + 1) * 50 - 13, 2);
         }
      }

      for(var2 = 0; var2 < this.q.length; ++var2) {
         this.q[var2].b(var1);
      }

      super.a(var1);
   }

   public final void a() {
      super.a();
      this.i.a();
   }

   public final void a(int var1, Object var2) {
      switch (var1) {
         case 1:
            Service.gI().a(this.q[0].d(), this.q[1].d(), this.q[2].d(), this.q[3].d(), this.q[4].d(), this.q[5].d(), this.q[6].d());
            GameCanvas.aw = false;
            GameScr.gI().a();
         default:
      }
   }

}
