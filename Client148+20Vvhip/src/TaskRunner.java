
public final class TaskRunner implements Runnable {

    private static String gameAB;
    private static String gameAC;
    public static boolean isRunning;

    TaskRunner(String string, String string2) {
        gameAC = string;
        gameAB = string2;
    }

    public final void run() {
        try {
            Thread.sleep(500L);

            while (isRunning) {

                RMS.gameAA("acc", gameAC);
                RMS.gameAA("pass", gameAB);

                Thread.sleep(5000);
                isRunning = false;
            }

        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }
}
