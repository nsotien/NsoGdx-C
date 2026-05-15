package base.game2;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public final class Message {
   public byte command;
   private ByteArrayOutputStream bos = null;
   private DataOutputStream dos = null;
   private ByteArrayInputStream dis = null;
   private DataInputStream ds = null;

   public Message() {
   }

   public Message(byte var1) {
      this.command = var1;
      this.bos = new ByteArrayOutputStream();
      this.dos = new DataOutputStream(this.bos);
   }

   public Message(byte var1, byte[] var2) {
      this.command = var1;
      this.dis = new ByteArrayInputStream(var2);
      this.ds = new DataInputStream(this.dis);
      Code.a(var1, var2);
   }

   public final byte[] a() {
      return this.bos.toByteArray();
   }

   public final DataInputStream b() {
      return this.ds;
   }

   public final DataOutputStream c() {
      return this.dos;
   }

   public final void d() {
      try {
         if (this.ds != null) {
            this.ds.close();
         }

         if (this.dos != null) {
            this.dos.close();
            return;
         }
      } catch (IOException var2) {
      }

   }

}
