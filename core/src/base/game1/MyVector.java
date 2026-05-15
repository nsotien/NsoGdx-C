package base.game1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public final class MyVector extends Vector {

   public final synchronized void addElement(Object var1) {
      super.addElement(var1);
   }

   public final synchronized Object elementAt(int var1) {
      return super.elementAt(var1);
   }

   public final synchronized void removeAllElements() {
      super.removeAllElements();
   }

   public final synchronized boolean removeElement(Object var1) {
      return super.removeElement(var1);
   }

   public final synchronized void insertElementAt(Object var1, int var2) {
      super.insertElementAt(var1, var2);
   }

   public final synchronized void removeElementAt(int var1) {
      super.removeElementAt(var1);
   }

}
