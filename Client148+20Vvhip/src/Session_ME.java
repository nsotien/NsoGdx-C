import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.io.SocketConnection;

public final class Session_ME implements ISession {
   public static Session_ME gameAA = new Session_ME();
   public DataOutputStream gameAB;
   public DataInputStream gameAC;
   public IMessageHandler gameAD;
   public SocketConnection gameAE;
   public boolean gameAF;
   public boolean gameAG;
   private Sender gameAQ = new Sender(this);
   private MessageCollector gameAR = new MessageCollector(this);
   private Thread gameAS;
   private Thread gameAT;
   private Thread gameAU;
   private Thread gameAV;
   public int gameAH;
   public int gameAI;
   public long gameAJ;
   private boolean gameAW;
   public byte[] gameAK = null;
   private byte gameAX;
   private byte gameAY;
   private long gameAZ;
   public String gameAL = "";
   public static String gameAM;
   public static int gameAN;
   public static byte gameAO;
   public static boolean gameAP;
   private static Object gameBA = new Object();

   public static Session_ME gameAA() {
      return gameAA;
   }

   public final void gameAA(String var1, int var2) {
      String var3 = "socket://" + var1 + ":" + var2;
      if (GameCanvas.gameAY) {
         if (!GameCanvas.isGPRS) {
            var3 = var3 + ";interface=wifi";
         } else {
            var3 = var3 + ";deviceside=true";
         }
      }
      if (!this.gameAF && !this.gameAG) {
         this.gameAW = false;
         this.gameAE = null;
         this.gameAS = new Thread(new NetworkConnector(this, var3));
         this.gameAS.start();
         gameAM = var1;
         gameAN = var2;
         gameAO = GameMidlet.serverLogin;
      }
   }

   public final void sendMessage(Message var1) {
      this.gameAQ.gameAA(var1);
   }

   private synchronized void gameAB(Message var1) {
      byte[] var2 = var1.gameAA();

      try {
         if (this.gameAW) {
            this.gameAB.writeByte(this.gameAA(var1.gameAA));
         } else {
            this.gameAB.writeByte(var1.gameAA);
         }

         if (var2 != null) {
            int var3 = var2.length;
            if (var1.gameAA != -31 && this.gameAW) {
               byte var5 = this.gameAA((byte)(var3 >> 8));
               this.gameAB.writeByte(var5);
               var5 = this.gameAA((byte)var3);
               this.gameAB.writeByte(var5);
            } else {
               this.gameAB.writeShort(var3);
            }

            if (this.gameAW) {
               for(int var6 = 0; var6 < var2.length; ++var6) {
                  var2[var6] = this.gameAA(var2[var6]);
               }
            }

            this.gameAB.write(var2);
            this.gameAH += 5 + var2.length;
         } else {
            this.gameAB.writeShort(0);
            this.gameAH += 5;
         }

         this.gameAB.flush();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   private byte gameAA(byte var1) {
      byte[] var10000 = this.gameAK;
      byte var10003 = this.gameAY;
      this.gameAY = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (this.gameAY >= this.gameAK.length) {
         this.gameAY = (byte)(this.gameAY % this.gameAK.length);
      }

      return var1;
   }

   public final void gameAB() {
      Code.gameAB();
      this.gameAC();
   }

   public final void gameAC() {
      this.gameAW = false;
      this.gameAF = false;
      this.gameAG = false;
      this.gameAK = null;
      this.gameAX = 0;
      this.gameAY = 0;
      this.gameAQ.gameAA();

      try {
         if (this.gameAE != null) {
            this.gameAE.close();
            this.gameAE = null;
         }

         if (this.gameAB != null) {
            this.gameAB.close();
            this.gameAB = null;
         }

         if (this.gameAC != null) {
            this.gameAC.close();
            this.gameAC = null;
         }

         if (this.gameAT != null) {
            if (this.gameAT.isAlive()) {
               this.gameAT.interrupt();
            }

            this.gameAT = null;
         }

         if (this.gameAS != null) {
            if (this.gameAS.isAlive()) {
               this.gameAS.interrupt();
            }

            this.gameAS = null;
         }

         if (this.gameAU != null) {
            if (this.gameAU.isAlive()) {
               this.gameAU.interrupt();
            }

            this.gameAU = null;
         }

         if (this.gameAV != null) {
            if (this.gameAV.isAlive()) {
               this.gameAV.interrupt();
            }

            this.gameAV = null;
         }

         System.gc();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public final void gameAD() {
      if (GameCanvas.currentScreen != GameCanvas.selectsvScr) {
         GameCanvas.instance.gameAE();
      }

      if (gameAP) {
         gameAE();
      } else {
         gameAP = true;
         (new Thread(new Login(this))).start();
      }
   }

   public static void gameAE() {
      Object var10000 = gameBA;
      synchronized(gameBA) {
         gameBA.notifyAll();
      }
   }

   public static Thread gameAA(Session_ME var0) {
      return var0.gameAS;
   }

   public static void gameAA(Session_ME var0, Thread var1) {
      var0.gameAT = var1;
   }

   public static Thread gameAB(Session_ME var0) {
      return var0.gameAT;
   }

   public static Sender gameAC(Session_ME var0) {
      return var0.gameAQ;
   }

   public static void gameAB(Session_ME var0, Thread var1) {
      var0.gameAU = var1;
   }

   public static MessageCollector gameAD(Session_ME var0) {
      return var0.gameAR;
   }

   public static void gameAC(Session_ME var0, Thread var1) {
      var0.gameAV = var1;
   }

   public static Thread gameAE(Session_ME var0) {
      return var0.gameAU;
   }

   public static Thread gameAF(Session_ME var0) {
      return var0.gameAV;
   }

   public static void gameAA(Session_ME var0, long var1) {
      var0.gameAZ = var1;
   }

   public static void gameAA(Session_ME var0, Message var1) {
      var0.gameAB(var1);
   }

   public static boolean gameAG(Session_ME var0) {
      return var0.gameAW;
   }

   public static byte gameAA(Session_ME var0, byte var1) {
      byte[] var10000 = var0.gameAK;
      byte var10003 = var0.gameAX;
      var0.gameAX = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (var0.gameAX >= var0.gameAK.length) {
         var0.gameAX = (byte)(var0.gameAX % var0.gameAK.length);
      }

      return var1;
   }

   static long gameAH(Session_ME var0) {
      return var0.gameAZ;
   }

   static void gameAI(Session_ME var0) {
      var0.gameAW = true;
   }

   public static void gameAA(long var0) {
      Object var10000 = gameBA;
      synchronized(gameBA) {
         try {
            gameBA.wait(var0);
         } catch (Exception var3) {
         }

      }
   }
}
