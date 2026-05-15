
public final class LockGame {

    private static boolean gameAC = false;
    public static boolean gameAA = false;
    public static boolean gameAB = false;
    private static boolean gameAD = false;
    private static boolean gameAE = false;
    private static boolean gameAF = false;
    private static boolean gameAG = false;
    private static boolean gameAH = false;
    private static boolean gameAI = false;
    private static boolean gameAJ = false;
    private static boolean gameAK = false;
    private static boolean gameAL = false;
    private static boolean gameAM = false;
    private static boolean gameAN = false;
    private static boolean gameAO = false;
    private static boolean gameAP = false;
    private static boolean gameAQ = false;
    private static Object gameAR = new Object();
    private static int gameAS;

    public static void gameAA() {
        gameAC = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAB() {
        if (gameAC) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAC = false;
        }

    }

    public static boolean gameAC() {
        gameAB = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(1L);
            } catch (InterruptedException var3) {
            }
        }

        return System.currentTimeMillis() - var0 < 1L;
    }

    public static void gameAD() {
        if (gameAB) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAB = false;
        }

    }

    public static void gameAE() {
        gameAD = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAF() {
        if (gameAD) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAD = false;
        }

    }

    public static void gameAG() {
        gameAE = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAH() {
        if (gameAE) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAE = false;
        }

    }

    public static void gameAI() {
        gameAJ = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait();
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAJ() {
        if (gameAJ) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAJ = false;
        }

    }

    public static void gameAK() {
        gameAF = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAL() {
        if (gameAF) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAF = false;
        }

    }

    public static void gameAM() {
        gameAG = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAN() {
        if (gameAG) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAG = false;
        }

    }

    public static void gameAO() {
        gameAH = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAP() {
        if (gameAH) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAH = false;
        }

    }

    public static boolean gameAQ() {
        gameAI = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(2000L);
            } catch (InterruptedException var3) {
            }
        }

        return System.currentTimeMillis() - var0 < 2000L;
    }

    public static void gameAR() {
        if (gameAI) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAI = false;
        }

    }

    public static boolean gameAS() {
        gameAK = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(7000L);
            } catch (InterruptedException var3) {
            }
        }

        return System.currentTimeMillis() - var0 < 7000L;
    }

    public static void gameAT() {
        if (gameAK) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAK = false;
        }

    }

    public static boolean gameAU() {
        gameAS = Auto.skill1 != null ? Auto.skill1.point : 0;
        gameAL = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(3000L);
            } catch (InterruptedException var2) {
            }
        }

        return Auto.skill1 == null || Auto.skill1.point > gameAS;
    }

    public static void gameAV() {
        if (gameAL) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAL = false;
        }

    }

    public static void gameAW() {
        gameAM = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(3000L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameAX() {
        if (gameAM) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAM = false;
        }

    }

    public static boolean gameAY() {
        gameAN = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(5000L);
            } catch (InterruptedException var3) {
            }
        }

        return System.currentTimeMillis() - var0 < 5000L;
    }

    public static void gameAZ() {
        if (gameAN) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAN = false;
        }

    }

    public static boolean gameBA() {
        gameAO = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(20000L);
            } catch (InterruptedException var3) {
            }
        }

        if (AutoSell.gameAV) {
            AutoSell.gameAV = false;
            return false;
        } else {
            return System.currentTimeMillis() - var0 < 20000L;
        }
    }

    public static boolean LockAA(long l) {
        gameAO = true;
        if (l < 0L) {
            Object object = gameAR;
            synchronized (object) {
                try {
                    gameAR.wait();
                } catch (InterruptedException interruptedException) {
                }
            }
            if (AutoSell.gameAV) {
                AutoSell.gameAV = false;
                return false;
            }
            return true;
        }
        long l2 = System.currentTimeMillis();
        Object object = gameAR;
        synchronized (object) {
            try {
                gameAR.wait(l);
            } catch (InterruptedException interruptedException) {
            }
        }
        if (AutoSell.gameAV) {
            AutoSell.gameAV = false;
            return false;
        }
        return System.currentTimeMillis() - l2 < l;
    }

    public static void gameBB() {
        if (gameAO) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAO = false;
        }

    }

    public static void gameBC() {
        gameAP = true;
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(500L);
            } catch (InterruptedException var2) {
            }

        }
    }

    public static void gameBD() {
        if (gameAP) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAP = false;
        }

    }

    public static boolean waitDV() {
        System.out.println("WaitDV");
        gameAQ = true;
        long var0 = System.currentTimeMillis();
        Object var10000 = gameAR;
        synchronized (gameAR) {
            try {
                gameAR.wait(10000L);
            } catch (InterruptedException var3) {
            }
        }

        return System.currentTimeMillis() - var0 < 10000L;
    }

    public static void notifyDV() {
        System.out.println("NotifyDV");
        if (gameAQ) {
            Object var10000 = gameAR;
            synchronized (gameAR) {
                gameAR.notifyAll();
            }

            gameAQ = false;
        }

    }

    public static boolean gameBG() {
        int var0 = 0;

        label31:
        while (var0 < Code.gameAI.size()) {
            String var1 = (String) Code.gameAI.elementAt(var0);

            for (int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
                Party var3;
                if ((var3 = (Party) GameScr.vParty.elementAt(var2)).name.equals(var1)) {
                    if (var3.c == null || Res.gameAA(Char.getMyChar().cx, Char.getMyChar().cy, var3.c.cx, var3.c.cy) > 100) {
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

    public static boolean gameBH() {
        label23:
        for (int var0 = 0; var0 < Code.gameAI.size(); ++var0) {
            String var1 = (String) Code.gameAI.elementAt(var0);

            for (int var2 = 0; var2 < GameScr.vParty.size(); ++var2) {
                if (((Party) GameScr.vParty.elementAt(var2)).name.equals(var1)) {
                    continue label23;
                }
            }

            return false;
        }

        return true;
    }

    public static void gameAA(long var0) {
        if (Code.gameAH != null) {
            long var2 = System.currentTimeMillis();

            while (!gameBG() && System.currentTimeMillis() - var2 < var0) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException var5) {
                    var5.printStackTrace();
                }
            }
        }

    }

    public static void gameBI() {
        if (Code.gameAH != null) {
            long var0 = System.currentTimeMillis();

            while (true) {
                try {
                    int var2 = 0;

                    boolean var7;
                    label41:
                    {
                        label40:
                        while (true) {
                            if (var2 >= Code.gameAI.size()) {
                                var7 = true;
                                break label41;
                            }

                            String var3 = (String) Code.gameAI.elementAt(var2);
                            int var4 = 0;

                            while (true) {
                                if (var4 >= GameScr.vParty.size()) {
                                    break label40;
                                }

                                Party var5;
                                if ((var5 = (Party) GameScr.vParty.elementAt(var4)).name.equals(var3)) {
                                    if (var5.c == null) {
                                        break label40;
                                    }

                                    ++var2;
                                    break;
                                }

                                ++var4;
                            }
                        }

                        var7 = false;
                    }

                    if (var7 || System.currentTimeMillis() - var0 >= 300000L) {
                        return;
                    }

                    Thread.sleep(2000L);
                } catch (InterruptedException var6) {
                    var6.printStackTrace();
                }
            }
        }
    }

    public static void gameBJ() {
        if (Code.gameAH != null) {
            long var0 = System.currentTimeMillis();

            while (!gameBH() && System.currentTimeMillis() - var0 < 60000L) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException var3) {
                    var3.printStackTrace();
                }
            }
        }

    }

    public static void gameBK() {
        Object var10000 = gameAR;
        synchronized (gameAR) {
            gameAR.notifyAll();
        }

        gameAB = false;
        gameAD = false;
        gameAE = false;
        gameAF = false;
        gameAG = false;
        gameAH = false;
        gameAJ = false;
        gameAC = false;
        gameAI = false;
        gameAA = false;
        gameAK = false;
        gameAL = false;
        gameAM = false;
        gameAN = false;
        gameAO = false;
        gameAP = false;
        TileMap.gameBE = false;
        TileMap.gameAG();
    }
}
