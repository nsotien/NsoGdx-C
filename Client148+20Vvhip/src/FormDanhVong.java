
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

public final class FormDanhVong implements CommandListener {

    private static ByteArrayInputStream bytein;
    private static DataInputStream datain;
    private static ByteArrayOutputStream byteout;
    private static DataOutputStream dataout;
    private static RecordStore loadata;
    private final Form form = new Form("menu dv");
    private final javax.microedition.lcdui.Command luu = new javax.microedition.lcdui.Command("Lưu", 4, 1);
    private final javax.microedition.lcdui.Command huy = new javax.microedition.lcdui.Command("Hủy", 3, 1);
    public static String TenDoiThu = "tenclone";
    private TextField tendt;
    public static int MapDV;
    public static int KhuDV;
    private TextField mapdv;
    private TextField khudv;
    public static int MapCS;
    public static int KhuCS;
    private TextField mapcs;
    private TextField khucs;
    public static int MapLD;
    public static int KhuLD;
    private TextField mapld;
    private TextField khuld;
    private final ChoiceGroup huydv;
    public static boolean tinhanh = false;
    public static boolean thulinh = false;
    public static boolean nangcap = false;
    public static boolean loidai = false;
    public static boolean kiemyen = false;
    public static boolean cuusat = false;
    private final ChoiceGroup caibh;
    public static boolean baohiem7 = false;
    public static boolean baohiem8 = false;

    public FormDanhVong() {
        this.tendt = new TextField("Tên Đối Thủ + ',': <Cách nhau bằng dấu phảy ','> ;", TenDoiThu, 1024, 0);
        this.mapld = new TextField("Map lôi đài", "" + MapLD, 3, 2);
        this.khuld = new TextField("Khu lôi đài", "" + KhuLD, 3, 2);
        this.mapdv = new TextField("Map Đánh Quái (Kiếm Yên + Nhặt Đá)", "" + MapDV, 3, 1);
        this.khudv = new TextField("Khu Đánh Quái (Kiếm Yên + Nhặt Đá)", "" + KhuDV, 3, 1);
        this.mapcs = new TextField("Map Cừu Sát", "" + MapCS, 3, 3);
        this.khucs = new TextField("Map Cừu Sát", "" + KhuCS, 3, 3);
        huydv = new ChoiceGroup("Hủy NVDV!!", 2, new String[]{"Đánh Tinh Anh", "Đánh Thủ Lĩnh", "Nâng Cấp Trang Bị", "Lôi Đài", "Kiếm Yên", "Cừu Sát"}, (Image[]) null);
        caibh = new ChoiceGroup("Cài Dùng Bảo Hiểm NVDV Nâng Cấp!!", 2, new String[]{"Dùng Bào Hiểm Nâng Lên 7", "Dùng Bào Hiểm Nâng Lên 8"}, (Image[]) null);

    }

    public final void select() {
        this.form.append(this.tendt);
        this.form.append(this.mapld);
        this.form.append(this.khuld);
        this.form.append(this.mapdv);
        this.form.append(this.khudv);
        this.form.append(this.mapcs);
        this.form.append(this.khucs);
        this.form.append(this.huydv);
        this.form.append(this.caibh);

        this.form.addCommand(this.luu);
        this.form.addCommand(this.huy);
        this.form.setCommandListener(this);
        this.huydv.setSelectedIndex(0, tinhanh);
        this.huydv.setSelectedIndex(1, thulinh);
        this.huydv.setSelectedIndex(2, nangcap);
        this.huydv.setSelectedIndex(3, loidai);
        this.huydv.setSelectedIndex(4, kiemyen);
        this.huydv.setSelectedIndex(5, cuusat);
        this.caibh.setSelectedIndex(0, baohiem7);
        this.caibh.setSelectedIndex(1, baohiem8);
        timelite(this.form);
    }

    private static void timelite(Displayable current) {
        Display.getDisplay(GameMidlet.instance).setCurrent(current);
    }

    public final void commandAction(javax.microedition.lcdui.Command command, Displayable displayable) {
        if (command == this.luu) {
            try {
                TenDoiThu = this.tendt.getString();
                MapLD = Integer.parseInt(this.mapld.getString());
                KhuLD = Integer.parseInt(this.khuld.getString());
                MapDV = Integer.parseInt(this.mapdv.getString());
                KhuDV = Integer.parseInt(this.khudv.getString());
                MapCS = Integer.parseInt(this.mapcs.getString());
                KhuCS = Integer.parseInt(this.khucs.getString());
                tinhanh = this.huydv.isSelected(0);
                thulinh = this.huydv.isSelected(1);
                nangcap = this.huydv.isSelected(2);
                loidai = this.huydv.isSelected(3);
                kiemyen = this.huydv.isSelected(4);
                cuusat = this.huydv.isSelected(5);
                baohiem7 = this.caibh.isSelected(0);
                baohiem8 = this.caibh.isSelected(1);
                byteout = new ByteArrayOutputStream();
                dataout = new DataOutputStream(byteout);

                try {
                    dataout.writeUTF(TenDoiThu);
                    dataout.writeInt(MapLD);
                    dataout.writeInt(KhuLD);
                    dataout.writeInt(MapDV);
                    dataout.writeInt(KhuDV);
                    dataout.writeInt(MapCS);
                    dataout.writeInt(KhuCS);
                    dataout.writeBoolean(tinhanh);
                    dataout.writeBoolean(thulinh);
                    dataout.writeBoolean(nangcap);
                    dataout.writeBoolean(loidai);
                    dataout.writeBoolean(kiemyen);
                    dataout.writeBoolean(cuusat);
                    dataout.writeBoolean(baohiem7);
                    dataout.writeBoolean(baohiem8);
                    dataout.flush();
                    dataout.close();
                    byteout.flush();
                    loadata = RecordStore.openRecordStore("MenuDV", true);
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
        MapLD = 1;
        KhuLD = 20;
        MapDV = -1;
        KhuDV = -1;
        MapCS = 2;
        KhuCS = 0;
        try {
            loadata = RecordStore.openRecordStore("MenuDV", true);
            if (loadata.getNumRecords() != 0) {
                bytein = new ByteArrayInputStream(loadata.getRecord(1));
                datain = new DataInputStream(bytein);
                TenDoiThu = datain.readUTF();
                MapLD = datain.readInt();
                KhuLD = datain.readInt();
                MapDV = datain.readInt();
                KhuDV = datain.readInt();
                MapCS = datain.readInt();
                KhuCS = datain.readInt();
                tinhanh = datain.readBoolean();
                thulinh = datain.readBoolean();
                nangcap = datain.readBoolean();
                loidai = datain.readBoolean();
                kiemyen = datain.readBoolean();
                cuusat = datain.readBoolean();
                baohiem7 = datain.readBoolean();
                baohiem8 = datain.readBoolean();
            }

            loadata.closeRecordStore();
        } catch (Exception var1) {
        }

    }
}
