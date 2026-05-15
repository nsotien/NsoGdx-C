package com.monkey.nso;

import javax.microedition.lcdui.Graphics;

/**
 * Provider vẽ overlay khi ngủ — implement ở mỗi package game1 / game2.
 * SleepManager chọn provider theo tab đang active (NSO.gameCanvas).
 *
 * Provider chịu trách nhiệm vẽ toàn bộ text (dùng mFont của package mình),
 * bao gồm cả fallback khi chưa vào game.
 */
public interface ISleepInfo {
    /**
     * Vẽ overlay text. SpriteBatch đã begin() bên ngoài (trong NSO.render).
     * @param g        javax.microedition.lcdui.Graphics wrapper (có SpriteBatch bên trong)
     * @param screenW  width screen theo game coord (đã chia zoom, tức GameCanvas.aa)
     * @param screenH  height screen theo game coord (GameCanvas.ab)
     */
    void drawOverlay(Graphics g, int screenW, int screenH);
}
