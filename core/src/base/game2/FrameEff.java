package base.game2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class FrameEff {
   public MyVector a = new MyVector();
   public MyVector b = new MyVector();

   public FrameEff(MyVector var1, MyVector var2) {
      this.a = var1;
      this.b = var2;
   }

}
