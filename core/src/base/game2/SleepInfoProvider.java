package base.game2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.microedition.lcdui.Graphics;

import com.monkey.nso.ISleepInfo;
import com.monkey.nso.SleepManager;

public class SleepInfoProvider implements ISleepInfo {

    private static final class Line {
        final String[] segs;
        Line(String... segs) { this.segs = segs; }
        boolean isBlank() { return segs.length == 0; }
    }

    @Override
    public void drawOverlay(Graphics g, int screenW, int screenH) {
        mGraphics mg = new mGraphics(g);

        Char me = Char.getMyChar();
        Auto mode = Code.mode;
        if (me == null || TileMap.mapName == null || TileMap.mapName.length() == 0 || mode == null) {
            String fb = "NST - V8 SLEEP";
            int fbW = base.game2.mFont.l.a(fb);
            base.game2.mFont.l.a(mg, fb, (screenW - fbW) / 2, screenH / 2, 0);
            return;
        }

        List<Line> lines = new ArrayList<Line>();

        String modeName = null;
        try { modeName = mode.toString(); } catch (Throwable t) { modeName = null; }
        if (modeName == null || modeName.length() == 0) modeName = mode.getClass().getSimpleName();
        lines.add(new Line(modeName));
        boolean hasAutoSection = true;

        if (Code.pkam) {
            lines.add(new Line("Auto PK âm ", menu_pkam.ptpk + "%"));
            hasAutoSection = true;
        }

        if (MenuHangDong.autohd) {
            lines.add(new Line("Auto hang động ",
                    MenuHangDong.gio_hd + "h" + MenuHangDong.phut_hd + "p"));
            hasAutoSection = true;
        }

        if (KichYen.active) {
            lines.add(new Line("Kích yên"));
            hasAutoSection = true;
        }

        if (FormDanhVong.isADanhVong && !(mode instanceof AutoDanhVong)
                && FormDanhVong.advAH >= 0 && FormDanhVong.advAI >= 0) {
            String dvTime = (FormDanhVong.advAH < 10 ? "0" : "") + FormDanhVong.advAH
                    + "h" + (FormDanhVong.advAI < 10 ? "0" : "") + FormDanhVong.advAI;
            lines.add(new Line("Auto DV ", dvTime));
            hasAutoSection = true;
        }

        if (Code.isAutoNVHN && !(mode instanceof AutoNVHN)
                && Code.nvhnHour >= 0 && Code.nvhnMin >= 0) {
            String nvhnTime = (Code.nvhnHour < 10 ? "0" : "") + Code.nvhnHour
                    + "h" + (Code.nvhnMin < 10 ? "0" : "") + Code.nvhnMin;
            lines.add(new Line("Auto NVHN ", nvhnTime));
            hasAutoSection = true;
        }

        if (hasAutoSection) lines.add(new Line());

        long curExpInLevel = me.cExpDown > 0L ? me.cExpDown : me.ae;
        long expMax = 1L;
        long[] expsArr = GameScr.exps;
        if (expsArr != null && me.cLevel >= 0 && me.cLevel < expsArr.length && expsArr[me.cLevel] > 0L) {
            expMax = expsArr[me.cLevel];
        }
        float expPct = (float) (curExpInLevel * 10000L / expMax) / 100.0F;
        String charLine = me.cName + " - " + me.cLevel
                + " (" + String.format(Locale.US, "%.2f", expPct) + "%)";
        lines.add(new Line("Nhân vật: ", charLine));

        lines.add(new Line(
                "Map: ", TileMap.mapName + " - ",
                "Khu ", String.valueOf(TileMap.zoneID)));

        lines.add(new Line("Yên hiện có: ", formatDotNum(me.yen)));

        lines.add(new Line());
        long elapsedMs = System.currentTimeMillis() - mode.time_start_auto;
        int elapsedSec = (int) (elapsedMs / 1000L);
        String yenStr, lvStr;
        int totalMin = elapsedSec / 60;
        int hrs = totalMin / 60;
        int mins = totalMin % 60;
        String timeUpStr = hrs > 0 ? hrs + "h" + mins + "p" : mins + "p";
        if (elapsedSec > 0) {
            long yenDelta = (long) me.yen - (long) mode.yen_before;
            long yenPerH = yenDelta * 3600L / (long) elapsedSec;
            yenStr = formatDotNum(yenPerH) + "/1h";

            long expDelta = me.cEXP - mode.level_before;
            long expPerH = expDelta * 3600L / (long) elapsedSec;
            float pctPerH = (float) (expPerH * 10000L / expMax) / 100.0F;
            lvStr = String.format(Locale.US, "%.2f%%/1h", pctPerH);
        } else {
            yenStr = "0/1h";
            lvStr = "0.00%/1h";
        }
        lines.add(new Line("Time up: ", timeUpStr));
        lines.add(new Line("Yên: ", yenStr));
        lines.add(new Line("Level: ", lvStr));

        // RAM + CPU: chi hien tren PC, APK/IPA bo qua
        if (SleepManager.isDesktop()) {
            lines.add(new Line());
            lines.add(new Line("Ram: ", SleepManager.getRamStr()));
            lines.add(new Line("CPU: ", SleepManager.getCpuStr()));
        }

        int lineH = 12;
        int n = lines.size();
        int totalH = n * lineH;
        int startY = (screenH - totalH) / 2;

        for (int i = 0; i < n; i++) {
            Line ln = lines.get(i);
            int y = startY + i * lineH;
            if (ln.isBlank()) continue;
            drawLineCentered(mg, ln, screenW, y);
        }
    }

    private static void drawLineCentered(mGraphics mg, Line ln, int screenW, int y) {
        int totalW = 0;
        for (int i = 0; i < ln.segs.length; i++) {
            base.game2.mFont fnt = (i % 2 == 0) ? base.game2.mFont.j : base.game2.mFont.l;
            totalW += fnt.a(ln.segs[i]);
        }
        int x = (screenW - totalW) / 2;
        for (int i = 0; i < ln.segs.length; i++) {
            base.game2.mFont fnt = (i % 2 == 0) ? base.game2.mFont.j : base.game2.mFont.l;
            String s = ln.segs[i];
            fnt.a(mg, s, x, y, 0);
            x += fnt.a(s);
        }
    }

    private static String formatDotNum(long n) {
        return String.format(Locale.US, "%,d", n).replace(',', '.');
    }
}
