
import javax.microedition.lcdui.Image;

public final class LossPk extends Auto {

    public final void gameaAC() {
        super.gameAC();

    }

    public final void gameAK() {
        if (Auto.reAC()) {
            if (Char.ReMap) {
                Controller.gameAD().onDisconnected();
                Auto.gameAA(true);
            }

        }

        if (Char.ReMap) {
            this.gameAA(FormDanhVong.MapCS, FormDanhVong.KhuCS, -1, -1);
        }

    }

    public final String toString() {
        return "Bị Cừu Sát !";
    }

}
