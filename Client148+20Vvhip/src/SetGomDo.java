
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;

public final class SetGomDo implements CommandListener {

    private final Form gameAD = new Form("Setting Gom Đồ!");
    private TextField gameAE;
    private TextField gameAF;
    private TextField gameAG;
    private TextField gameAH;
    private TextField gameAI;
    private TextField gameAJ;
    private TextField gameAK;
    private Command gameAL;
    public static String itemgd = "";
    public static String itemcat = "454,455,456,457";


    public SetGomDo() {
        boolean var1 = AutoNhan.nguoinhan == null;
        this.gameAE = new TextField("Name nhận đồ", var1 ? "vth" : AutoNhan.nguoinhan, 10000, 0);
        this.gameAF = new TextField("Giờ nhận đồ", var1 ? "0" : String.valueOf(AutoNhan.gionhan), 2, 2);
        this.gameAG = new TextField("Item GD <Mỗi ID cách nhau bằng dấu phảy > Nhập id item", itemgd, 1000, 0);
        this.gameAK = new TextField("Item Cất <Mỗi ID cách nhau bằng dấu phảy > Nhập id item", itemcat, 1000, 0);
        this.gameAH = new TextField("Phút nhận đồ", var1 ? "0" : String.valueOf(AutoNhan.phutnhan), 2, 2);
        this.gameAI = new TextField("Map nhận đồ", var1 ? "22" : String.valueOf(AutoNhan.mapnhan), 4, 2);
        this.gameAJ = new TextField("Khun Vực nhận", var1 ? "20" : String.valueOf(AutoNhan.khunhan), 3, 2);
        this.gameAL = new Command("Lưu", 4, 0);
    }

    public final void gameAA() {
        this.gameAD.append(this.gameAE);
        this.gameAD.append(this.gameAG);
        this.gameAD.append(this.gameAF);
        this.gameAD.append(this.gameAH);
        this.gameAD.append(this.gameAI);
        this.gameAD.append(this.gameAJ);
        this.gameAD.append(this.gameAK);
        this.gameAD.addCommand(this.gameAL);
        this.gameAD.addCommand(new Command("Thoát", 7, 0));
        this.gameAD.setCommandListener(this);
        gameAA(this.gameAD);
    }

    private static void gameAA(Displayable var0) {
        Display.getDisplay(GameMidlet.instance).setCurrent(var0);
    }

    public final void commandAction(Command var1, Displayable var2) {
        if (var1 == this.gameAL) {
            AutoNhan.nguoinhan = this.gameAE.getString();
            itemgd = this.gameAG.getString();
            itemcat = this.gameAK.getString();
            try {
                AutoNhan.gionhan = Byte.parseByte(this.gameAF.getString());
                AutoNhan.phutnhan = Byte.parseByte(this.gameAH.getString());
                AutoNhan.mapnhan = Integer.parseInt(this.gameAI.getString());
                AutoNhan.khunhan = Byte.parseByte(this.gameAJ.getString());
            } catch (Exception var4) {
            }

            GameCanvas.gameAA("Lưu cài đặt thành công");
            AutoNhan.gameaAG();
        }

        gameAA(MotherCanvas.gI());
    }
}
