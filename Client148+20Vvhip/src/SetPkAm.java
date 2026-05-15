import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public final class SetPkAm extends Form implements CommandListener {
   private final TextField gameAA;
   private final TextField gameAB;
   private final TextField gameAC;
   private final TextField gameAD;
   private final TextField gameAE;
   private final TextField gameAF;
   private final javax.microedition.lcdui.Command gameAG;

   public SetPkAm() {
      super("Cài khu chờ pk và đánh pk");
      this.append(this.gameAA = new TextField("Khu chờ PK:", String.valueOf(Code.gameBU), 2, 2));
      this.append(this.gameAB = new TextField("Khu đánh PK:", String.valueOf(Code.gameBV), 2, 2));
      this.append(this.gameAC = new TextField("ID map PK - (map hiện tại: " + TileMap.mapID + ")", Code.gameBW != -1 ? String.valueOf(Code.gameBW) : "70", 3, 2));
      this.append(this.gameAD = new TextField("Vị trí X - (vt hiện tại: " + Char.getMyChar().cx + ")", Code.gameBX != -1 ? String.valueOf(Code.gameBX) : "1500", 9, 2));
      this.append(this.gameAE = new TextField("Vị trí Y - (vt hiện tại: " + Char.getMyChar().cy + ")", Code.gameBY != -1 ? String.valueOf(Code.gameBY) : "528", 9, 2));
      this.append("Lưu ý: những cài đặt này cả 3 acc phải cài giống hệt nhau!");
      this.append(this.gameAF = new TextField("Bao nhiêu % thì auto UpPK:", String.valueOf(Code.gameBZ), 2, 2));
      this.append("P/s: Cài đặt này dành cho acc chính!");
      this.addCommand(this.gameAG = new javax.microedition.lcdui.Command("Save", 4, 0));
      this.addCommand(new javax.microedition.lcdui.Command("Cancel", 7, 0));
      this.setCommandListener(this);
   }

   public final void gameAA() {
      Display.getDisplay(GameMidlet.instance).setCurrent(this);
   }

   public final void commandAction(javax.microedition.lcdui.Command var1, Displayable var2) {
      if (var1 == this.gameAG) {
         try {
            Code.gameBU = Integer.parseInt(this.gameAA.getString());
            Code.gameBV = Integer.parseInt(this.gameAB.getString());
            Code.gameBW = Integer.parseInt(this.gameAC.getString());
            Code.gameBX = Integer.parseInt(this.gameAD.getString());
            Code.gameBY = Integer.parseInt(this.gameAE.getString());
            Code.gameBZ = Long.parseLong(this.gameAF.getString());
            RMS.gameAA("chipAutopk", Code.gameBU + ";" + Code.gameBV + ";" + Code.gameBW + ";" + Code.gameBX + ";" + Code.gameBY + ";" + (int)Code.gameBZ);
            GameCanvas.gameAA("Lưu cài đặt thành công");
         } catch (NumberFormatException var3) {
         }
      }

      Display.getDisplay(GameMidlet.instance).setCurrent(MotherCanvas.gI());
   }
}
