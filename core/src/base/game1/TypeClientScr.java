package base.game1;

/**
 * Màn chọn giao diện: Bản Đẹp / Java Ngang / Java Dọc
 * Adapted from V8 TypeClientScr → TGAME naming.
 */
public final class TypeClientScr extends mScreen implements IActionListener {
    private int popupW;
    private int popupH;
    private int popupX;
    private int popupY;
    private int indexRow = -1;

    public final void a() {
        // TGAME: a() = update/show screen
        GameScr.j = GameCanvas.ab;
        if (GameCanvas.at == 2) {
            GameCanvas.b(0);
        } else {
            GameCanvas.b(TileMap.versionMap);
        }

        super.a();
        if (GameScr.instance != null) {
            GameScr.instance = null;
        }

        if ((TileMap.versionMap = (byte)((int)(System.currentTimeMillis() % 9L))) == 5 || TileMap.versionMap == 6) {
            TileMap.versionMap = 4;
        }

        GameScr.a(true);
        GameScr.p = 100;
        this.popupW = 170;
        this.popupH = 200;
        if (GameCanvas.aa == 128 || GameCanvas.ab <= 208) {
            this.popupW = 126;
            this.popupH = 160;
        }

        this.popupX = GameCanvas.aa / 2 - this.popupW / 2;
        this.popupY = GameCanvas.ab / 2 - this.popupH / 2;
        if (GameCanvas.ab <= 250) {
            this.popupY -= 10;
        }

        super.a = new Command1("Quay lại", GameCanvas.instance, 8884, (Object) null);
        super.c = new Command1("Thoát", GameCanvas.instance, 8885, (Object) null);
        this.indexRow = -1;
        if (!GameCanvas.g) {
            this.indexRow = 0;
        }
    }

    // TGAME: a(mGraphics) = paint
    public final void a(mGraphics var1) {
        var1.a(0);
        var1.d(0, 0, GameCanvas.aa, GameCanvas.ab);
        GameCanvas.a(var1);
        Paint.a(this.popupX, this.popupY, this.popupW, this.popupH, var1);

        // Title "Chọn Phiên Bản"
        String title = "Chọn Phiên Bản";
        var1.a(Paint.c);
        var1.b(GameCanvas.ac - mFont.o.a(title) / 2 - 12, this.popupY + 7, mFont.o.a(title) + 22, 24, 6, 6);
        var1.a(Paint.b);
        var1.a(GameCanvas.ac - mFont.o.a(title) / 2 - 12, this.popupY + 7, mFont.o.a(title) + 22, 24, 6, 6);
        mFont.o.a(var1, title, GameCanvas.ac, this.popupY + 12, 2);

        // Chi hien giao dien duoc bat trong NSO.enabledClientTypes
        String[] allNames = new String[]{"Bản Đẹp", "Bản Java Ngang", "Bản Java Dọc"};
        int[] enabled = com.monkey.nso.NSO.enabledClientTypes;
        int startY = this.popupY + 50;

        for (int i = 0; i < enabled.length; ++i) {
            String name = (enabled[i] >= 0 && enabled[i] < allNames.length) ? allNames[enabled[i]] : "???";
            var1.a(Paint.c);
            var1.d(this.popupX + 10, startY + i * 35, this.popupW - 20, 28);
            var1.a(5720393);
            var1.c(this.popupX + 10, startY + i * 35, this.popupW - 20, 28);
            if (i == this.indexRow) {
                var1.a(Paint.b);
                var1.d(this.popupX + 10, startY + i * 35, this.popupW - 20, 28);
                var1.a(11053224);
                var1.c(this.popupX + 10, startY + i * 35, this.popupW - 20, 28);
            }

            mFont.e.a(var1, name, this.popupX + this.popupW / 2, startY + i * 35 + 8, 2);
        }

        super.a(var1);
        Paint.a(var1, super.a, super.b, super.c);
    }

    // TGAME: d() = tick/update loop
    public final void d() {
        if (++GameScr.p > GameCanvas.aa * 3 + 100) {
            GameScr.p = 100;
        }
        super.d();
    }

    // TGAME: e() = input processing
    public final void e() {
        int count = com.monkey.nso.NSO.enabledClientTypes.length;
        if (GameCanvas.n[2] || GameCanvas.n[4] || GameCanvas.n[6] || GameCanvas.n[8]) {
            this.indexRow = (this.indexRow + 1) % count;
        }

        if (GameCanvas.r && GameCanvas.q) {
            int clickY = GameCanvas.t - (this.popupY + 45);
            if (clickY >= 0 && clickY < count * 35) {
                this.indexRow = clickY / 35;
                this.a(1000, (Object) null);
            }
        }

        super.e();
    }

    // TGAME: a(int, Object) = action performed
    public final void a(int var1, Object var2) {
        switch (var1) {
            case 1000:
                int[] enabled = com.monkey.nso.NSO.enabledClientTypes;
                if (this.indexRow >= 0 && this.indexRow < enabled.length) {
                    int realType = enabled[this.indexRow];
                    GameCanvas.aj = null;
                    RMS.deleteAllResInNso();
                    RMS.a("typeClient", realType);
                    DebugLog.log("TypeClient", "Selected: " + this.indexRow);
                    System.exit(-1);
                }
                break;
            default:
                break;
        }
    }
}
