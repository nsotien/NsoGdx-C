package com.monkey.nso.lib;

import com.badlogic.gdx.graphics.Texture;
import javax.microedition.lcdui.Graphics;

public class TextureBoard {
    private short Field0;
    private short Field1;
    public Texture Field2;

    public TextureBoard(Texture var1, int var2, int var3) {
        if (var1 != null) {
            this.Field2 = var1;
        }
        this.Field0 = (short) var2;
        this.Field1 = (short) var3;
    }


    public void paint(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
        if (this.Field2 != null) {
            var6.drawRegion(this.Field2, 0, var1 * this.Field1, this.Field0, this.Field1, var4, var2, var3, var5);
        }

    }
}
