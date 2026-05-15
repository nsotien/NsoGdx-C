package base.game2;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 * Hybrid MotherCanvas: TGAME logic + V8 LibGDX bridge.
 */
public final class MotherCanvas extends Canvas {
    // TGAME fields
    public static MotherCanvas a;      // TGAME singleton
    public Class_em b;                  // TGAME rendering delegate
    private int c = 1;                  // TGAME scale factor

    // V8 fields
    public static MotherCanvas instance; // V8 singleton alias
    public int zoomLevel = 1;            // V8 zoom level (set by NSO)

    // V8 singleton method (called by NSO)
    public static MotherCanvas gI() {
        if (instance == null) {
            instance = new MotherCanvas();
            a = instance;
        }
        return instance;
    }

    public MotherCanvas() {
        mGraphics.b = 1;  // TGAME: set scale factor
    }

    // TGAME: MotherCanvas.a(Class_em) — set rendering delegate
    public final void a(Class_em var1) {
        this.b = var1;
    }

    public void paint(Graphics var1) {
        if (this.b != null) {
            this.b.a(var1);
        }
    }

    // TGAME: keyPressed
    public void keyPressed(int var1) {
        if (this.b != null) {
            this.b.c(var1);
        }
    }

    // TGAME: keyReleased
    public void keyReleased(int var1) {
        if (this.b != null) {
            this.b.d(var1);
        }
    }

    // TGAME: pointerDragged (with zoom scaling)
    public void pointerDragged(int var1, int var2) {
        var1 /= this.zoomLevel;
        var2 /= this.zoomLevel;
        if (this.b != null) {
            this.b.a(var1, var2);
        }
    }

    // TGAME: pointerPressed (with zoom scaling)
    public void pointerPressed(int var1, int var2) {
        var1 /= this.zoomLevel;
        var2 /= this.zoomLevel;
        if (this.b != null) {
            this.b.b(var1, var2);
        }
    }

    // TGAME: pointerReleased (with zoom scaling)
    public void pointerReleased(int var1, int var2) {
        var1 /= this.zoomLevel;
        var2 /= this.zoomLevel;
        if (this.b != null) {
            this.b.c(var1, var2);
        }
    }

    // TGAME: get height
    public final int a() {
        return super.getHeight() / zoomLevel;
    }

    // TGAME: get width
    public final int b() {
        return super.getWidth() / zoomLevel;
    }

    public boolean hasPointerEvents() {
        return true;
    }

    public void repaint() {
    }

    public void serviceRepaints() {
    }

    // V8: update() — called by NSO.render() each frame
    public void update() {
        try {
            if (this.b != null) {
                this.b.update();
            }
        } catch (Exception var7) {
            ;
        }
    }
}
