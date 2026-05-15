package base.game1;

public final class LockGame {
   private static boolean advAC = false;
   public static boolean advAA = false;
   public static boolean advAB = false;
   private static boolean advAD = false;
   private static boolean advAE = false;
   private static boolean advAF = false;
   private static boolean advAG = false;
   private static boolean advAH = false;
   private static boolean advAI = false;
   private static boolean advAJ = false;
   private static boolean advAK = false;
   private static boolean advAL = false;
   private static boolean advAM = false;
   private static boolean advAN = false;
   private static boolean advAO = false;
   private static boolean advAP = false;
   private static boolean advAQ = false;
   private static Object advAR = new Object();
   private static int advAS;

   // --- advAA/advAB: wait 2s / notify ---
   public static void advAA() {
      advAC = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAB() {
      if (advAC) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAC = false;
      }
   }

   // --- advAC/advAD: wait 500ms (return <50ms) / notify ---
   public static boolean advAC() {
      advAB = true;
      long var0 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(500L);
         } catch (InterruptedException var3) {
         }
      }
      return System.currentTimeMillis() - var0 < 50L;
   }

   public static void advAD() {
      if (advAB) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAB = false;
      }
   }

   // --- advAE/advAF: wait 2s / notify ---
   public static void advAE() {
      advAD = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAF() {
      if (advAD) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAD = false;
      }
   }

   // --- advAG/advAH: wait 2s / notify ---
   public static void advAG() {
      advAE = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAH() {
      if (advAE) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAE = false;
      }
   }

   // --- advAI/advAJ: wait indefinite / notify ---
   public static void advAI() {
      advAJ = true;
      synchronized (advAR) {
         try {
            advAR.wait();
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAJ() {
      if (advAJ) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAJ = false;
      }
   }

   // --- advAK/advAL: wait 2s / notify ---
   public static void advAK() {
      advAF = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAL() {
      if (advAF) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAF = false;
      }
   }

   // --- advAM/advAN: wait 2s / notify ---
   public static void advAM() {
      advAG = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAN() {
      if (advAG) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAG = false;
      }
   }

   // --- advAO/advAP: wait 2s / notify ---
   public static void advAO() {
      advAH = true;
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAP() {
      if (advAH) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAH = false;
      }
   }

   // --- advAQ/advAR: wait 2s (return bool) / notify ---
   public static boolean advAQ() {
      advAI = true;
      long var0 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(2000L);
         } catch (InterruptedException var3) {
         }
      }
      return System.currentTimeMillis() - var0 < 2000L;
   }

   public static void advAR() {
      if (advAI) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAI = false;
      }
   }

   // --- advAS/advAT: wait 7s (return bool) / notify ---
   public static boolean advAS() {
      advAK = true;
      long var0 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(7000L);
         } catch (InterruptedException var3) {
         }
      }
      return System.currentTimeMillis() - var0 < 7000L;
   }

   public static void advAT() {
      if (advAK) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAK = false;
      }
   }

   // --- advAU/advAV: wait 3s (return skill point change) / notify ---
   public static boolean advAU() {
      advAS = Auto.my_skill != null ? Auto.my_skill.point : 0;
      advAL = true;
      synchronized (advAR) {
         try {
            advAR.wait(3000L);
         } catch (InterruptedException var1) {
         }
      }
      return Auto.my_skill == null || Auto.my_skill.point > advAS;
   }

   public static void advAV() {
      if (advAL) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAL = false;
      }
   }

   // --- advAW/advAX: wait 3s / notify ---
   public static void advAW() {
      advAM = true;
      synchronized (advAR) {
         try {
            advAR.wait(3000L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advAX() {
      if (advAM) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAM = false;
      }
   }

   // --- advAY/advAZ: wait 5s (return bool) / notify ---
   public static boolean advAY() {
      advAN = true;
      long var0 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(5000L);
         } catch (InterruptedException var3) {
         }
      }
      return System.currentTimeMillis() - var0 < 5000L;
   }

   public static void advAZ() {
      if (advAN) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAN = false;
      }
   }

   // --- advBA/advBB: wait 20s (return bool) / notify ---
   public static boolean advBA() {
      advAO = true;
      long var1 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(20000L);
         } catch (InterruptedException var5) {
         }
      }
      return System.currentTimeMillis() - var1 < 20000L;
   }

   public static void advBB() {
      if (advAO) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAO = false;
      }
   }

   // --- advBC/advBD: wait 500ms / notify ---
   public static void advBC() {
      advAP = true;
      synchronized (advAR) {
         try {
            advAR.wait(500L);
         } catch (InterruptedException var1) {
         }
      }
   }

   public static void advBD() {
      if (advAP) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAP = false;
      }
   }

   // --- waitDV/notifyDV: wait 10s (return bool) / notify ---
   public static boolean waitDV() {
      ;
      advAQ = true;
      long var0 = System.currentTimeMillis();
      synchronized (advAR) {
         try {
            advAR.wait(10000L);
         } catch (InterruptedException var3) {
         }
      }
      return System.currentTimeMillis() - var0 < 10000L;
   }

   public static void notifyDV() {
      ;
      if (advAQ) {
         synchronized (advAR) {
            advAR.notifyAll();
         }
         advAQ = false;
      }
   }

   // --- Party utility: check tat ca party member gan ---
   public static boolean advBG() {
      int var0 = 0;

      label31:
      while (var0 < Code.listParty.size()) {
         String var1 = (String) Code.listParty.elementAt(var0);

         for (int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
            Party var3;
            if ((var3 = (Party) GameScr.vParty.elementAt(var2)).d.equals(var1)) {
               if (var3.f == null || Res.a(Char.getMyChar().cx1, Char.getMyChar().cy1, var3.f.cx1, var3.f.cy1) > 100) {
                  return false;
               }

               ++var0;
               continue label31;
            }
         }

         return false;
      }

      return true;
   }

   // --- Party utility: check tat ca party member online ---
   public static boolean advBH() {
      label23:
      for (int var0 = 0; var0 < Code.listParty.size(); ++var0) {
         String var1 = (String) Code.listParty.elementAt(var0);

         for (int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
            if (((Party) GameScr.vParty.elementAt(var2)).d.equals(var1)) {
               continue label23;
            }
         }

         return false;
      }

      return true;
   }

   // --- Party utility: doi tat ca party member gan (timeout) ---
   public static void advAA(long var0) {
      if (Code.listParty.size() > 0) {
         long var2 = System.currentTimeMillis();

         while (!advBG() && System.currentTimeMillis() - var2 < var0) {
            phong.sleep(2000L);
         }
      }
   }

   // --- Party utility: doi tat ca party member online + gan ---
   public static void advBI() {
      if (Code.listParty.size() > 0) {
         long var2 = System.currentTimeMillis();

         while (true) {
            int var0 = 0;

            boolean var10000;
            label37:
            while (true) {
               if (var0 >= Code.listParty.size()) {
                  var10000 = true;
                  break;
               }

               String var1 = (String) Code.listParty.elementAt(var0);

               for (int var4 = 0; var4 < GameScr.vParty.size(); ++var4) {
                  Party var5;
                  if ((var5 = (Party) GameScr.vParty.elementAt(var4)).d.equals(var1)) {
                     if (var5.f == null) {
                        var10000 = false;
                        break label37;
                     }

                     ++var0;
                     continue label37;
                  }
               }

               var10000 = false;
               break;
            }

            if (var10000 || System.currentTimeMillis() - var2 >= 300000L) {
               return;
            }

            phong.sleep(2000L);
         }
      }
   }

   // --- Party utility: doi tat ca party member online ---
   public static void advBJ() {
      if (Code.listParty.size() > 0) {
         long var0 = System.currentTimeMillis();

         while (!advBH() && System.currentTimeMillis() - var0 < 60000L) {
            phong.sleep(2000L);
         }
      }
   }

   // --- Reset tat ca flag ---
   public static void advBK() {
      synchronized (advAR) {
         advAR.notifyAll();
      }

      advAB = false;
      advAD = false;
      advAE = false;
      advAF = false;
      advAG = false;
      advAH = false;
      advAJ = false;
      advAC = false;
      advAI = false;
      advAA = false;
      advAK = false;
      advAL = false;
      advAM = false;
      advAN = false;
      advAO = false;
      advAP = false;
   }
}
