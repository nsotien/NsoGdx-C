package base.game2;

public class AutoLatHinh implements Runnable {
   public final int count;
   public static boolean b;

   public AutoLatHinh(int a) {
      this.count = a;
   }

   public void run() {
      for(int var1 = 0; var1 < this.count; ++var1) {
         GameScr.npc_b(30, 0, 0);
         GameScr.indexSelect = 0;
         Service.gI().selectCard();

         try {
            Thread.sleep(Code.speedLh);
         } catch (InterruptedException var3) {
            ;
         }

         if (var1 > Code.countLh) {
            break;
         }
      }

   }
}
