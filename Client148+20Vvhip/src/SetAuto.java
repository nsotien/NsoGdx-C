
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;

public final class SetAuto implements CommandListener {

    private static ByteArrayInputStream bytein;
    private static DataInputStream datain;
    private static ByteArrayOutputStream byteout;
    private static DataOutputStream dataout;
    private static RecordStore loadata;
    private final Form form = new Form("menu pro");
    private final javax.microedition.lcdui.Command luu = new javax.microedition.lcdui.Command("Lưu", 4, 1);
    private final javax.microedition.lcdui.Command huy = new javax.microedition.lcdui.Command("Hủy", 3, 1);
    public static boolean danh4skill = false;
    public static boolean idmap = true;
    public static boolean hienexp = false;
    public static boolean dcvt = false;
    public static boolean vbl = false;
    public static boolean dungx2 = false;
    public static boolean dungtnp = false;
    public static boolean gomdo = false;
    public static boolean catdo = false;
    public static boolean nvhn = false;
    private TextField gio1;
    private TextField phut1;
    public static int gionvhn = 1;
    public static int phutnvhn = 30;
    private final ChoiceGroup chonsk = new ChoiceGroup("Cài Đặt Chung!!", 2, new String[]{"Auto 4skill", "Hiện ID Map", "Hiện Exp/Yên Khi Up", "Hiệu Ứng Tele Quái", "Up bằng VBL", "Dùng x2", "Dùng TNP", "Gom Đồ", "Cất Đồ Khi Up", "Auto NVHN"}, (Image[]) null);
    private TextField tentele;
    public static String tenVBL = "";

    public SetAuto() {

        this.tentele = new TextField("Tên VBL", tenVBL, 1024, 0);
        this.gio1 = new TextField("Giờ NVHN", "" + gionvhn, 2, 2);
        this.phut1 = new TextField("Phút NVHN", "" + phutnvhn, 2, 2);
    }

    public final void select() {
        this.form.append(this.chonsk);
        this.form.append(this.tentele);
        this.form.append(this.gio1);
        this.form.append(this.phut1);

        this.form.addCommand(this.luu);
        this.form.addCommand(this.huy);
        this.form.setCommandListener(this);
        this.chonsk.setSelectedIndex(0, danh4skill);
        this.chonsk.setSelectedIndex(1, idmap);
        this.chonsk.setSelectedIndex(2, hienexp);
        this.chonsk.setSelectedIndex(3, dcvt);
        this.chonsk.setSelectedIndex(4, vbl);
        this.chonsk.setSelectedIndex(5, dungx2);
        this.chonsk.setSelectedIndex(6, dungtnp);
        this.chonsk.setSelectedIndex(7, gomdo);
        this.chonsk.setSelectedIndex(8, catdo);
        this.chonsk.setSelectedIndex(9, nvhn);

        timelite(this.form);
    }

    private static void timelite(Displayable current) {
        Display.getDisplay(GameMidlet.instance).setCurrent(current);
    }

    public final void commandAction(javax.microedition.lcdui.Command command, Displayable displayable) {
        if (command == this.luu) {
            try {
                danh4skill = this.chonsk.isSelected(0);
                idmap = this.chonsk.isSelected(1);
                hienexp = this.chonsk.isSelected(2);
                dcvt = this.chonsk.isSelected(3);
                vbl = this.chonsk.isSelected(4);
                dungx2 = this.chonsk.isSelected(5);
                dungtnp = this.chonsk.isSelected(6);
                gomdo = this.chonsk.isSelected(7);
                catdo = this.chonsk.isSelected(8);
                nvhn = this.chonsk.isSelected(9);

                tenVBL = this.tentele.getString();
                gionvhn = Integer.parseInt(this.gio1.getString());
                phutnvhn = Integer.parseInt(this.phut1.getString());
                byteout = new ByteArrayOutputStream();
                dataout = new DataOutputStream(byteout);

                try {
                    dataout.writeBoolean(danh4skill);
                    dataout.writeBoolean(idmap);
                    dataout.writeBoolean(hienexp);
                    dataout.writeBoolean(dcvt);
                    dataout.writeBoolean(vbl);
                    dataout.writeBoolean(dungx2);
                    dataout.writeBoolean(dungtnp);
                    dataout.writeBoolean(gomdo);
                    dataout.writeBoolean(catdo);
                    dataout.writeBoolean(nvhn);

                    dataout.writeUTF(tenVBL);
                    dataout.writeInt(gionvhn);
                    dataout.writeInt(phutnvhn);
                    dataout.flush();
                    dataout.close();
                    byteout.flush();
                    loadata = RecordStore.openRecordStore("smenu", true);
                    byte[] byteArray = byteout.toByteArray();
                    byteout.close();
                    if (loadata.getNumRecords() == 0) {
                        loadata.addRecord(byteArray, 0, byteArray.length);
                    } else {
                        loadata.setRecord(1, byteArray, 0, byteArray.length);
                    }

                    loadata.closeRecordStore();
                } catch (Exception var4) {
                }

                GameCanvas.gameAA("Lưu cài đặt thành công");
            } catch (NumberFormatException var5) {
            }
        }

        timelite(MotherCanvas.gI());
    }

    static {
        try {
            loadata = RecordStore.openRecordStore("smenu", true);
            if (loadata.getNumRecords() != 0) {
                bytein = new ByteArrayInputStream(loadata.getRecord(1));
                datain = new DataInputStream(bytein);
                danh4skill = datain.readBoolean();
                idmap = datain.readBoolean();
                hienexp = datain.readBoolean();
                dcvt = datain.readBoolean();
                vbl = datain.readBoolean();
                dungx2 = datain.readBoolean();
                dungtnp = datain.readBoolean();
                gomdo = datain.readBoolean();
                catdo = datain.readBoolean();
                nvhn = datain.readBoolean();

                tenVBL = datain.readUTF();
                gionvhn = datain.readInt();
                phutnvhn = datain.readInt();
            }

            loadata.closeRecordStore();
        } catch (Exception var1) {
        }

    }
}
