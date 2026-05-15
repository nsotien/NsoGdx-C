/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.microedition.lcdui;

import com.badlogic.gdx.Gdx;
import com.monkey.nso.NSO;

/**
 *
 * @author admin
 */
public abstract class Canvas extends Displayable {

    public boolean isPaint;
    public Canvas() {
    }

    public void setFullScreenMode(boolean mode) {
    }

    public void keyPressed(int keyCode) {
    }

    public void keyRepeated(int keyCode) {
    }

    public void keyReleased(int keyCode) {
    }

    public abstract void paint(Graphics paramGraphics);

    public void pointerPressed(int x, int y) {
    }

    public void pointerReleased(int x, int y) {
    }

    public void pointerDragged(int x, int y) {
    }

    public int getHeight() {
        return NSO.getHeight();
    }

    public int getWidth() {
        return NSO.getWidth();
    }
    public void update()
    {
        
    }

}
