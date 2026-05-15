package com.monkey.nso;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * ============================================================================
 *  HƯỚNG DẪN CHỈNH THÔNG SỐ HIỂN THỊ CHO 3 BẢN CLIENT × 3 NỀN TẢNG
 * ============================================================================
 *  typeClient (tc) — giá trị user chọn ở màn TypeClientScr:
 *    tc = 0  →  "Bản Đẹp"       : đồ hoạ cao, UI lớn, zoom 2x. Mặc định landscape.
 *    tc = 1  →  "Bản Java Ngang": phong cách Java cổ, landscape, zoom 1x.
 *    tc = 2  →  "Bản Java Dọc"  : phong cách Java cổ, PORTRAIT (xoay camera 90°),
 *                                 tự động bật keyboard ảo (xem NSO.java:189).
 *
 *  CÁC THAM SỐ (đọc trong NSO.create() quanh dòng 130-175):
 *    • targetShortEdge  — QUAN TRỌNG NHẤT.
 *        Là pixel của cạnh NGẮN viewport logic.
 *        divisor = min(baseW,baseH) / targetShortEdge  (nếu divisor<1 bị kẹp về 1).
 *        → targetShortEdge CÀNG LỚN → UI/chữ/nhân vật CÀNG NHỎ (thấy nhiều map hơn).
 *        → targetShortEdge CÀNG NHỎ → UI/chữ/nhân vật CÀNG TO (thấy ít map hơn).
 *        Ví dụ: màn 1080p landscape, shorter=1080. Đặt 1000 → divisor~1.08 (gần 1:1);
 *               đặt 540  → divisor=2    (mọi thứ x2);
 *               đặt 360  → divisor=3    (mọi thứ x3).
 *
 *    • zoomLevel  — 1/2/3/4. Chọn BỘ font + sprite nào.
 *        Không phải "phóng to" viewport mà là đổi tài nguyên vẽ.
 *        Thường đi đôi: tc=0 → zoom=2 (bộ hi-res), tc=1/tc=2 → zoom=1 (bộ Java gốc).
 *
 *    • rotateForPortrait — true = xoay camera 90° và hoán W/H.
 *        Chỉ bật khi muốn chơi dọc (tc=2). Kéo theo: NSO swap baseW/baseH và dùng
 *        ExtendViewport(HEIGHT,WIDTH) thay vì (WIDTH,HEIGHT).
 *
 *    • divisor (tham số truyền vào constructor) — CHỈ LÀ FALLBACK.
 *        Bị bỏ qua khi targetShortEdge > 0 (NSO.java:152). Giữ 1.0 là đủ.
 *
 *    • keyBoardHeightRatio, loginMenuYOffset — hiện chưa được đọc ở đâu trong
 *        codebase (field dự phòng). Đổi giá trị không có tác dụng cho tới khi
 *        code vẽ keyboard / login menu chịu đọc chúng.
 *
 *  WINDOW SIZE DESKTOP (nằm ngoài file này, trong NSO.java:136-142):
 *    tc=0 → giữ size từ launcher (fullscreen / maximized).
 *    tc=1 → setWindowedMode(960, 540)   — landscape nhỏ.
 *    tc=2 → setWindowedMode(700, 900)   — portrait.
 *    Muốn đổi kích thước cửa sổ PC thì sửa trong NSO.java, KHÔNG phải file này.
 *
 *  NGUYÊN TẮC VÀNG KHI CHỈNH:
 *    ① KHÔNG được để 3 bản (tc 0/1/2) trùng nhau về targetShortEdge + zoom —
 *       phải thấy rõ khác biệt sau khi build, nếu không bản Đẹp / Ngang / Dọc
 *       sẽ giống hệt nhau, người chơi không phân biệt được.
 *    ② Mỗi lần chỉnh chỉ đụng 1 nhánh (1 giá trị tc) của 1 platform. Đừng
 *       "tiện tay" sửa luôn nhánh khác — rất dễ cross-contaminate giữa 3 bản.
 *    ③ Sau khi chỉnh: chạy thử TẤT CẢ 3 tc trên nền tảng vừa chỉnh.
 * ============================================================================
 */
public final class PlatformConfig {
    public enum Platform { DESKTOP, ANDROID, IOS }

    public final Platform platform;
    public final double divisor;
    public final int zoomLevel;
    public final boolean rotateForPortrait;
    public final int keyBoardHeightRatio;
    public final int loginMenuYOffset;
    public final int targetShortEdge;

    private PlatformConfig(Platform p, double divisor, int zoomLevel,
                           boolean rotatePortrait,
                           int kbRatio, int menuY) {
        this(p, divisor, zoomLevel, rotatePortrait, kbRatio, menuY, 0);
    }

    private PlatformConfig(Platform p, double divisor, int zoomLevel,
                           boolean rotatePortrait,
                           int kbRatio, int menuY, int targetShortEdge) {
        this.platform = p;
        this.divisor = divisor;
        this.zoomLevel = zoomLevel;
        this.rotateForPortrait = rotatePortrait;
        this.keyBoardHeightRatio = kbRatio;
        this.loginMenuYOffset = menuY;
        this.targetShortEdge = targetShortEdge;
    }

    public static PlatformConfig detect(int typeClient) {
        int pixels = Gdx.graphics.getWidth() * Gdx.graphics.getHeight();
        Application.ApplicationType t = Gdx.app.getType();
        if (t == Application.ApplicationType.Desktop) return forDesktop(typeClient);
        if (t == Application.ApplicationType.iOS) return forIOS(typeClient);
        return forMobile(Platform.ANDROID, typeClient, pixels);
    }

    private static PlatformConfig forDesktop(int tc) { // ==================== PC ====================
        int targetShort, zoom;
        if (tc == 0) {
            // --- PC · Bản Đẹp ---
            // targetShort=1000: cạnh ngắn logic 1000px. Màn 1080p landscape (shorter=1080)
            //   → divisor ≈ 1.08, gần như 1:1 pixel → đồ hoạ sắc nét, không scale.
            // zoom=2: dùng bộ font/sprite hi-res. Cặp đôi tiêu chuẩn cho bản Đẹp.
            // Muốn UI to hơn trên PC: GIẢM targetShort (vd 800). Muốn thấy map rộng hơn: TĂNG (vd 1200).
            targetShort = 1200; zoom = 2;
        } else if (tc == 1) {
            // --- PC · Bản Java Ngang ---
            // Window bị ép 960x540 (NSO.java:140). shorter = 540.
            // targetShort=600 → divisor = 540/600 = 0.9 → bị kẹp về 1.0 → pixel 1:1.
            // zoom=1: bộ font/sprite Java gốc (nhỏ, pixel-art).
            // Muốn chữ to hơn trong Java Ngang: GIẢM targetShort xuống 400–500 cho divisor=1.
            // (Tăng không có tác dụng vì đã bị kẹp ≥1.)
            targetShort = 500; zoom = 1;
        } else { // tc == 2
            // --- PC · Bản Java Dọc ---
            // Window bị ép 700x900 portrait (NSO.java:138). shorter = 700.
            // Desktop KHÔNG rotate camera như mobile (rotatePortrait=false ở dòng return),
            //   vì window đã portrait sẵn rồi — rotate nữa sẽ hỏng trục.
            // targetShort=500 → divisor = 700/500 = 1.4 → UI to vừa.
            // Muốn UI to thêm trên Java Dọc PC: GIẢM targetShort (vd 400 → divisor=1.75).
            targetShort = 400; zoom = 1;
        }
        // Desktop tc=2 dùng window portrait (700x900) trực tiếp — KHÔNG rotate camera như Android.
        // Tham số thứ 2 (1.0) là `divisor` fallback, bị bỏ qua vì targetShort > 0.
        // kbRatio=3, menuY=80 — hiện chưa được code đọc, giữ nguyên cho khớp constructor.
        return new PlatformConfig(Platform.DESKTOP, 1.0, zoom, false, 3, 80, targetShort);
    }

    private static PlatformConfig forMobile(Platform p, int tc, int pixels) { // ==================== APK ====================
        // pixels = Gdx.graphics.getWidth() * getHeight() của màn máy thật.
        // Ngưỡng 135_600 ≈ 320x424 (≈ FWVGA thấp). Dưới ngưỡng = máy rất cũ/yếu.
        int targetShort, zoom;
        if (tc == 0) {
            // --- APK · Bản Đẹp ---
            if (pixels > 135_600) {
                // Máy hiện đại (đa số điện thoại từ 2015 trở đi).
                // targetShort=1000 + zoom=2: giống PC bản Đẹp. UI/chữ bộ hi-res, scale tối thiểu.
                // Muốn máy HD+ thấy UI lớn hơn: giảm xuống 800–900.
                targetShort = 800; zoom = 2;
            } else {
                // Máy cổ/yếu (dưới ~135k pixel). Dùng targetShort rất nhỏ để UI to dễ bấm.
                // targetShort=200 → shorter/200 ra divisor lớn → mọi thứ phóng to nhiều lần.
                // zoom=1 vì bộ hi-res có thể quá nặng cho máy yếu.
                targetShort = 200; zoom = 1;
            }
        } else if (tc == 1) {
            // --- APK · Bản Java Ngang ---
            // targetShort=700, zoom=1. Cảm giác "retro Java" trên máy Android.
            // Muốn chữ to hơn: giảm về 500–600.
            targetShort = 400; zoom = 1;
        } else { // tc == 2
            // --- APK · Bản Java Dọc ---
            // targetShort=600, zoom=1. rotate=true bên dưới → camera xoay 90°, chơi dọc.
            // Lưu ý: sau khi rotate, "shorter" vẫn là min(W,H) nên công thức divisor vẫn đúng.
            // Muốn map dọc dài hơn: tăng targetShort. Muốn chữ to hơn: giảm targetShort.
            targetShort = 500; zoom = 1;
        }
        // Chỉ tc=2 mới xoay sang portrait. NSO.java sẽ swap baseW/baseH và dùng ExtendViewport(H,W).
        boolean rotate = (tc == 2);
        // Lưu ý: (1.0) là divisor fallback (bỏ qua vì targetShort>0). kbRatio=3, menuY=90 chưa dùng.
        return new PlatformConfig(p, 1.0, zoom, rotate, 3, 90, targetShort);
    }

    private static PlatformConfig forIOS(int tc) { // ==================== iOS ====================
        // iOS KHÔNG có logic theo pixel như APK (không có cơ chế ép setWindowedMode như Desktop).
        // Dùng ExtendViewport + targetShortEdge là cách đúng để tránh bị crop trên notch/Dynamic Island.
        // KHÔNG được dùng FillViewport với design dims cố định → sẽ crop nặng trên iPhone tỉ lệ lạ.
        int targetShort, zoom;
        if (tc == 0) {
            // --- iOS · Bản Đẹp ---
            // targetShort=1000 + zoom=2. Trên iPhone 6.1" (shorter≈1170) → divisor≈1.17.
            // Muốn iPad thấy UI không quá nhỏ: giữ 1000 (iPad shorter lớn → divisor≈2 là ổn).
            // Nếu thấy chữ quá nhỏ trên iPhone mini: giảm xuống 800.
            targetShort = 800; zoom = 2;
        } else if (tc == 1) {
            // --- iOS · Bản Java Ngang ---
            // targetShort=700, zoom=1.
            // Muốn bản Java trên iOS giống cảm giác máy Java cổ: giảm targetShort xuống 400–500.
            targetShort = 400; zoom = 1;
        } else { // tc == 2
            // --- iOS · Bản Java Dọc ---
            // targetShort=600, zoom=1, rotate=true.
            // Khác Desktop: iOS KHÔNG ép window size → vẫn dùng resolution thật của máy.
            // Rotate camera 90° là cách duy nhất để game chạy portrait trên iOS.
            targetShort = 400; zoom = 1;
        }
        boolean rotate = (tc == 2);
        // (1.0) là divisor fallback (bỏ qua). kbRatio=3, menuY=90 hiện chưa dùng.
        return new PlatformConfig(Platform.IOS, 1.0, zoom, rotate, 3, 90, targetShort);
    }
}
