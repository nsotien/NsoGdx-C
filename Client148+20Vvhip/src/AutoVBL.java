/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cuong
 */
public class AutoVBL {
    public static long timeVBL;

    public static void usevbl() {
        if (System.currentTimeMillis() - timeVBL >= 3000L) {
            timeVBL = System.currentTimeMillis();
        }
         Service.gI().useItem(Char.gameAI(279));
        Service.gI().gameAA((short)1, SetAuto.tenVBL);
    }
}
