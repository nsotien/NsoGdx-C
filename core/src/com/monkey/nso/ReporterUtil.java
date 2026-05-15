package com.monkey.nso;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Utility cho ClientErrorReporter. Tach class de dau dat doc.
 * Khong dung lib JSON ngoai (Gdx-json co the chua co tren classpath).
 */
final class ReporterUtil {

    private static final int STACK_CAP = 8000;
    private static final int PREVIEW_CAP_DEFAULT = 500;

    private ReporterUtil() {}

    /** JSON escape — basic */
    static String esc(String s) {
        if (s == null) return "";
        StringBuffer sb = new StringBuffer(s.length() + 8);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\\': sb.append("\\\\"); break;
                case '"':  sb.append("\\\""); break;
                case '\n': sb.append("\\n"); break;
                case '\r': sb.append("\\r"); break;
                case '\t': sb.append("\\t"); break;
                case '\b': sb.append("\\b"); break;
                case '\f': sb.append("\\f"); break;
                default:
                    if (c < 0x20) sb.append("\\u").append(hex4(c));
                    else sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String hex4(int c) {
        String h = Integer.toHexString(c);
        while (h.length() < 4) h = "0" + h;
        return h;
    }

    /** Build JSON object from Hashtable (String/Number/Boolean values; nested Hashtable supported). */
    static String toJsonObject(Hashtable h) {
        if (h == null || h.isEmpty()) return "{}";
        StringBuffer sb = new StringBuffer(256);
        sb.append('{');
        boolean first = true;
        Enumeration en = h.keys();
        while (en.hasMoreElements()) {
            Object k = en.nextElement();
            Object v = h.get(k);
            if (!first) sb.append(',');
            first = false;
            sb.append('"').append(esc(k == null ? "" : k.toString())).append("\":");
            appendValue(sb, v);
        }
        sb.append('}');
        return sb.toString();
    }

    private static void appendValue(StringBuffer sb, Object v) {
        if (v == null) {
            sb.append("null");
        } else if (v instanceof Number) {
            sb.append(v.toString());
        } else if (v instanceof Boolean) {
            sb.append(((Boolean) v).booleanValue() ? "true" : "false");
        } else if (v instanceof Hashtable) {
            sb.append(toJsonObject((Hashtable) v));
        } else {
            sb.append('"').append(esc(v.toString())).append('"');
        }
    }

    /** Full stack trace (limit STACK_CAP chars). */
    static String stackTrace(Throwable t) {
        if (t == null) return "";
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.flush();
            String s = sw.toString();
            if (s.length() > STACK_CAP) {
                s = s.substring(0, STACK_CAP) + "\n... (truncated, total=" + s.length() + ")";
            }
            return s;
        } catch (Throwable th) {
            return t.getClass().getName() + ": " + t.getMessage();
        }
    }

    /** Substring + truncated note. */
    static String preview(String s, int max) {
        if (s == null) return "";
        if (max <= 0) max = PREVIEW_CAP_DEFAULT;
        if (s.length() <= max) return s;
        return s.substring(0, max) + "... (truncated, total=" + s.length() + ")";
    }

    static String preview(String s) {
        return preview(s, PREVIEW_CAP_DEFAULT);
    }
}
