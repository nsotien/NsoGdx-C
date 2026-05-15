
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.rms.RecordStore;

public final class Account implements CommandListener {

    private DataInputStream gameAB;
    private Command gameAC;
    public List gameAA;
    private Command gameAD;
    private ByteArrayInputStream gameAF;
    private TextField gameAH;
    private Command gameAI;
    private ByteArrayOutputStream gameAJ;
    private TextField gameAL;
    private Command gameAM;
    private DataOutputStream gameAN;
    private RecordStore gameAO;
    private int gameAP = -1;
    private Vector gameAQ = new Vector();
    private Command gameAR;
    private Command gameAS;
    private Vector gameAT = new Vector();
    private Form gameAU;

    public Account() {
        this.gameAU = new Form("Thêm tài khoản"); 
        this.gameAL = new TextField("Tài khoản", "", 500, 0); 
        this.gameAU.append(this.gameAL);
        this.gameAH = new TextField("Mật khẩu", "", 500, 65536);
        this.gameAU.append(this.gameAH);

        this.gameAR = new Command("Thêm", 4, 2);
        this.gameAU.addCommand(this.gameAR);
        this.gameAD = new Command("Hủy", 2, 2); 
        this.gameAU.addCommand(this.gameAD);
        this.gameAU.setCommandListener(this);
        this.gameAB();
        this.gameAA = new List("Danh Sách", 3); 
        for (int i = 0; i < this.gameAQ.size(); ++i) {
            this.gameAA.append(String.valueOf(i + 1) + " - " + this.gameAQ.elementAt(i)
                    , null);
        }
        this.gameAM = new Command("Thêm", 2, 2);
        this.gameAA.addCommand(this.gameAM);
        this.gameAS = new Command("Đăng nhập", 4, 1);
        this.gameAA.addCommand(this.gameAS);
        this.gameAC = new Command("Xóa", 2, 1);
        this.gameAA.addCommand(this.gameAC);
        this.gameAI = new Command("Thoát", 2, 1);
        this.gameAA.addCommand(this.gameAI);
        this.gameAA.setCommandListener(this);
    }

    public void gameAA() {
        try {
            this.gameAO = RecordStore.openRecordStore("RecordStoreName", true); 
            this.gameAJ = new ByteArrayOutputStream();
            this.gameAN = new DataOutputStream(this.gameAJ);
            for (int i = 0; i < this.gameAQ.size(); ++i) {
                this.gameAN.writeUTF(this.gameAQ.elementAt(i) + ":" + this.gameAT.elementAt(i));
            }
            byte[] byArray = this.gameAJ.toByteArray();
            if (this.gameAO.getNumRecords() == 0) {
                this.gameAO.addRecord(byArray, 0, byArray.length);
            } else {
                this.gameAO.setRecord(1, byArray, 0, byArray.length);
            }
            this.gameAN.close();
            this.gameAJ.close();
        } catch (Exception exception) {
        }
    }

    public final void commandAction(Command command, Displayable displayable) {
        if (command == this.gameAS) {
            this.gameAP = this.gameAA.getSelectedIndex();
            if (this.gameAP != -1) {
                String selectedItem = String.valueOf(this.gameAQ.elementAt(this.gameAP));
                String selectedValue = String.valueOf(this.gameAT.elementAt(this.gameAP));
                RMS.gameAA("acc", selectedItem);
                RMS.gameAA("pass", selectedValue); 
                Display.getDisplay(GameMidlet.instance).setCurrent(MotherCanvas.gI());
                
                new Thread(new TaskRunner(selectedItem, selectedValue)).start();

                //nameAB.gameAA = 1; // Decoded
               // new Thread(new nameAB(selectedItem, selectedValue)).start();
            }
        } else {
            if (command == this.gameAM) {
                Display.getDisplay(GameMidlet.instance).setCurrent(this.gameAU);
            } else if (command == this.gameAD) {
                Display.getDisplay(GameMidlet.instance).setCurrent(this.gameAA);
                this.gameAL.setString("");
                this.gameAH.setString("");
            } else if (command == this.gameAR) {
                if (!this.gameAL.getString().equals("") && !this.gameAH.getString().equals("")) {
                    this.gameAQ.addElement(this.gameAL.getString());
                    this.gameAT.addElement(this.gameAH.getString());
                    this.gameAA();
                    this.gameAA.append(String.valueOf(this.gameAQ.size()) + " - "
                            + this.gameAQ.elementAt(this.gameAQ.size() - 1),
                             null);
                    Display.getDisplay(GameMidlet.instance).setCurrent(this.gameAA);
                    this.gameAL.setString("");
                    this.gameAH.setString("");
                }
            } else if (command == this.gameAC) {
                int n = this.gameAA.getSelectedIndex();
                if (n != -1) {
                    this.gameAQ.removeElementAt(n);
                    this.gameAT.removeElementAt(n);
                    this.gameAA.delete(n);
                }
                this.gameAA();
            } else if (command == this.gameAI) {
                Display.getDisplay(GameMidlet.instance).setCurrent(MotherCanvas.gI());
            }
        }
    }

    public static String[] gameAAA(String var0, String var1) {
        Vector var2 = new Vector();

        for (int var3 = var0.indexOf(var1); var3 >= 0; var3 = (var0 = var0.substring(var3 + var1.length())).indexOf(var1)) {
            var2.addElement(var0.substring(0, var3));
        }

        var2.addElement(var0);
        String[] var4 = new String[var2.size()];
        if (var2.size() > 0) {
            for (int var5 = 0; var5 < var2.size(); ++var5) {
                var4[var5] = (String) var2.elementAt(var5);
            }
        }

        return var4;
    }

    private void gameAB() {
        try {
            this.gameAO = RecordStore.openRecordStore("RecordStoreName", true); 
            if (this.gameAO.getNumRecords() == 1) {
                String string;
                this.gameAF = new ByteArrayInputStream(this.gameAO.getRecord(1));
                this.gameAB = new DataInputStream(this.gameAF);
                while (!(string = this.gameAB.readUTF()).equals("")) {
                    String[] parts = gameAAA(string, ":");
                    this.gameAQ.addElement(parts[0]);
                    this.gameAT.addElement(parts[1]);
                }
                this.gameAB.close();
                this.gameAF.close();
            }
        } catch (Exception exception) {
        }
    }
}
