package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.microedition.lcdui.Graphics;

public abstract class Class_em {

   protected abstract void a(Graphics var1);

   protected abstract void c(int var1);

   protected abstract void d(int var1);

   protected abstract void a(int var1, int var2);

   protected abstract void b(int var1, int var2);

   protected abstract void c(int var1, int var2);

   // V8 bridge: called by MotherCanvas.update() from NSO render loop
   public void update() {}

   // V8 bridge aliases for MotherCanvas compatibility
   public void setIputType(int var1) { c(var1); }
   public void gameAD(int var1) { d(var1); }
   public void gameAA(int var1, int var2) { a(var1, var2); }
   public void gameAB(int var1, int var2) { b(var1, var2); }
   public void gameAC(int var1, int var2) { c(var1, var2); }
   public void gameAA(Graphics var1) { a(var1); }

}
