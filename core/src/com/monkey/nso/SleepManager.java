package com.monkey.nso;

import javax.microedition.lcdui.Graphics;

import com.badlogic.gdx.Gdx;

/**
 * Idle sleep — sau N phút không có input, skip paint game + giảm FPS.
 * Game logic (auto farm) vẫn chạy bình thường.
 *
 * Overlay khi ngủ: delegate cho provider của tab đang active (ISleepInfo.drawOverlay).
 * Provider dùng mFont của game (giống info góc trái ingame).
 *
 * Hook trong NSO:
 *   tick()         — đầu mỗi frame, check idle timeout
 *   touch()        — reset timer, wakeup nếu ngủ
 *   isSleeping()   — bọc gameCanvas.paint()
 *   drawOverlay()  — gọi provider vẽ text khi ngủ
 *   extraSleepMs() — thêm vào Thread.sleep
 */
public class SleepManager {

    // ==================== Idle timer ====================

    public static int timeoutMinutes = 1;
    public static boolean enabled = true;

    private static long lastInputTime = System.currentTimeMillis();
    private static long sleepStartTime = 0L;
    private static boolean sleeping = false;
    private static boolean paintSkipLogged = false;

    private static final long EXTRA_SLEEP_MS = 150L;

    public static void tick() {
        if (!enabled || sleeping) return;
        long idle = System.currentTimeMillis() - lastInputTime;
        if (idle >= (long) timeoutMinutes * 60_000L) {
            enterSleep(idle);
        }
    }

    public static boolean touch() {
        boolean wasAsleep = sleeping;
        lastInputTime = System.currentTimeMillis();
        if (sleeping) exitSleep();
        return wasAsleep;
    }

    public static void onPaintSkipped() {
        if (!paintSkipLogged) {
            ;
            paintSkipLogged = true;
        }
    }

    public static boolean isSleeping() { return sleeping; }
    public static long extraSleepMs() { return sleeping ? EXTRA_SLEEP_MS : 0L; }

    private static void enterSleep(long idleMs) {
        sleeping = true;
        paintSkipLogged = false;
        sleepStartTime = System.currentTimeMillis();
        ;
    }

    private static void exitSleep() {
        sleeping = false;
        long sleptMs = System.currentTimeMillis() - sleepStartTime;
        ;
    }

    // ==================== Provider registry ====================

    private static ISleepInfo provider1;
    private static ISleepInfo provider2;

    /** 1 = game1, 2 = game2. NSO.render() set trước khi gọi drawOverlay. */
    public static int activeTab = 1;

    public static void registerProvider(int tab, ISleepInfo provider) {
        if (tab == 1) provider1 = provider;
        else if (tab == 2) provider2 = provider;
    }

    /**
     * Delegate vẽ overlay cho provider của tab đang active.
     * SpriteBatch đã begin() bên ngoài. Provider chịu trách nhiệm vẽ toàn bộ text.
     */
    public static void drawOverlay(Graphics g, int screenW, int screenH) {
        ISleepInfo p = (activeTab == 2) ? provider2 : provider1;
        if (p == null) return;
        try {
            p.drawOverlay(g, screenW, screenH);
        } catch (Throwable t) {
            ;
        }
    }

    // ==================== RAM / CPU ====================
    // Pattern theo NST_MICRO/SystemMonitor: background scheduler 250ms sample lien tuc
    // — JVM internal counter co lich su day du -> getCpuLoad() tra gia tri muot, khop Task Manager.
    // Khong dung JNA (V8 khong co dependency); chi xai com.sun.management.OperatingSystemMXBean qua reflection.

    private static volatile String cachedRam = "-";
    private static volatile String cachedCpu = "-";
    private static volatile boolean schedulerStarted = false;
    private static Object osBean;
    private static java.lang.reflect.Method cpuLoadMethod;       // getCpuLoad / getSystemCpuLoad
    private static java.lang.reflect.Method ramTotalMethod;      // getTotalMemorySize / getTotalPhysicalMemorySize
    private static java.lang.reflect.Method ramFreeMethod;       // getFreeMemorySize / getFreePhysicalMemorySize

    /** True chi khi chay tren PC (desktop LWJGL). APK/IPA tra false -> overlay khong hien RAM/CPU, scheduler khong start. */
    public static boolean isDesktop() {
        try {
            return Gdx.app != null && Gdx.app.getType() == com.badlogic.gdx.Application.ApplicationType.Desktop;
        } catch (Throwable t) {
            return false;
        }
    }

    private static java.lang.reflect.Method findMethod(Class<?> clz, String[] names) {
        for (int i = 0; i < names.length; i++) {
            try { return clz.getMethod(names[i]); } catch (Throwable ignored) {}
        }
        return null;
    }

    private static synchronized void startSchedulerIfNeeded() {
        if (schedulerStarted) return;
        schedulerStarted = true;
        if (!isDesktop()) return;

        // F0c: bao toan bo trong reflection — R8 (Android release) khong thay reference truc tiep
        // den java.lang.management.* nen khong shrink/fail build. Android runtime se ClassNotFoundException
        // -> catch -> osBean=null -> sampleOnce skip. Desktop runtime van chay binh thuong.
        try {
            Class<?> mfClass = Class.forName("java.lang.management.ManagementFactory");
            osBean = mfClass.getMethod("getOperatingSystemMXBean").invoke(null);
            Class<?> sunBean = Class.forName("com.sun.management.OperatingSystemMXBean");
            if (sunBean.isInstance(osBean)) {
                cpuLoadMethod = findMethod(sunBean, new String[]{"getCpuLoad", "getSystemCpuLoad"});
                ramTotalMethod = findMethod(sunBean, new String[]{"getTotalMemorySize", "getTotalPhysicalMemorySize"});
                ramFreeMethod = findMethod(sunBean, new String[]{"getFreeMemorySize", "getFreePhysicalMemorySize"});
            }
        } catch (Throwable ignored) {}

        // Background daemon thread: sample 250ms/lan -> JVM build du lich su -> CPU muot.
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try { sampleOnce(); } catch (Throwable ignored) {}
                    try { Thread.sleep(250L); } catch (InterruptedException e) { return; }
                }
            }
        }, "NST-SystemMonitor");
        t.setDaemon(true);
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }

    private static void sampleOnce() {
        // RAM
        if (ramTotalMethod != null && ramFreeMethod != null) {
            try {
                long total = ((Long) ramTotalMethod.invoke(osBean)).longValue();
                long free  = ((Long) ramFreeMethod.invoke(osBean)).longValue();
                if (total > 0L) {
                    double pct = (total - free) * 100.0 / (double) total;
                    if (pct < 0) pct = 0; else if (pct > 100) pct = 100;
                    cachedRam = String.format(java.util.Locale.US, "%.0f%%", pct);
                }
            } catch (Throwable ignored) {}
        }
        // CPU
        if (cpuLoadMethod != null) {
            try {
                double v = ((Double) cpuLoadMethod.invoke(osBean)).doubleValue();
                if (v >= 0.0) {
                    double pct = v * 100.0;
                    if (pct < 0) pct = 0; else if (pct > 100) pct = 100;
                    cachedCpu = String.format(java.util.Locale.US, "%.0f%%", pct);
                }
            } catch (Throwable ignored) {}
        }
    }

    public static String getRamStr() { startSchedulerIfNeeded(); return cachedRam; }
    public static String getCpuStr() { startSchedulerIfNeeded(); return cachedCpu; }
}
