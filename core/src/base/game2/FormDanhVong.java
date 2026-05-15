package base.game2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.*;

public final class FormDanhVong extends Form implements CommandListener {
   public static boolean DEBUG_DV = false;
   public static boolean isADanhVong = false;
   public static String advAB = "";
   public static int advAC = 72;
   public static int advAD = 22;
   public static int advAE = -1;
   public static int advAF = -1;
   public static int advAG = 1000;
   public static int advAH = -1;
   public static int advAI = -1;
   public static short advAJ = -1;
   public static byte advAK = 0;
   public static byte advAL = 5;
   public static int advAM = 7;
   public static byte advAN = 2;
   public static byte advAO = 0;
   public static byte advAP = 0;
   public static boolean advAQ = false;
   public static byte advAR = 0;
   public static boolean advAS = false;
   public static boolean advAT = true;
   public static boolean huyNvLoiDai = false;
   private final TextField advAU;
   private final TextField advAV;
   private final TextField advAW;
   private final TextField advAX;
   private final TextField advAY;
   private final TextField advAZ;
   private final ChoiceGroup advBA;
   private final ChoiceGroup advBB;
   private final ChoiceGroup advBC;
   private final ChoiceGroup advBD;
   private final ChoiceGroup advBE;
   private final ChoiceGroup advBF;
   private final ChoiceGroup advBG;
   private final TextField advBH;
   private final TextField advBI;
   private final TextField advBJ;
   private final TextField advBK;
   private final TextField advBL;
   private final TextField advBM;
   private final Command advBN;
   private static FormDanhVong advBO;

   public static void advAA() {
      byte[] var0;
      if ((var0 = RMS.loadRMS("chipAutodv")) != null) {
         ByteArrayInputStream var11 = new ByteArrayInputStream(var0);
         DataInputStream var1 = new DataInputStream(var11);

         try {
            advAB = var1.readUTF();
            advAC = var1.readInt();
            advAD = var1.readInt();
            advAE = var1.readInt();
            advAF = var1.readInt();
            advAG = var1.readInt();
            advAH = var1.readInt();
            advAI = var1.readInt();
            isADanhVong = var1.readBoolean();
            advAJ = var1.readShort();
            advAN = var1.readByte();
            advAK = var1.readByte();
            advAL = var1.readByte();
            advAO = var1.readByte();
            advAM = var1.readInt();
            advAP = var1.readByte();
            advAQ = var1.readBoolean();
            advAR = var1.readByte();
            advAS = var1.readBoolean();
            advAT = var1.readBoolean();
            try {
               huyNvLoiDai = var1.readBoolean();
            } catch (java.io.EOFException eofLD) {
               huyNvLoiDai = false;
            }
            if (DEBUG_DV) ;
         } catch (Exception var9) {
            if (DEBUG_DV) ;
            RMS.deleteRMS("chipAutodv");
         } finally {
            try {
               var1.close();
               var11.close();
            } catch (IOException var8) {
            }
         }
      }

      advBO = new FormDanhVong();
   }

   public static FormDanhVong advAB() {
      return advBO;
   }

   private FormDanhVong() {
      super("Cai dat Danh Vong");
      this.advAY = new TextField("Nang cap max: ", String.valueOf(advAL), 2, 2);
      this.advAZ = new TextField("Chi dap do dang + <= ", String.valueOf(advAM), 2, 2);
      this.append(this.advBA = new ChoiceGroup("Tự đi làm DV?", 1, new String[]{"Bat", "Tat"}, (Image[]) null));
      this.append(this.advAV = new TextField("Gio Auto DV: ", String.valueOf(advAH), 2, 2));
      this.append(this.advAW = new TextField("Phut Auto DV: ", String.valueOf(advAI), 2, 2));
      this.append(this.advAU = new TextField("Xu cuoc loi dai: ", String.valueOf(advAG), 10, 2));
      this.append(this.advBI = new TextField("Doi thu la: ", advAB, 32, 0));
      this.append(this.advBJ = new TextField("Map lôi dai: ", String.valueOf(advAC), 3, 2));
      this.append(this.advBK = new TextField("Khu lôi dai: ", String.valueOf(advAD), 3, 2));
      this.append(this.advBL = new TextField("Map danh vong: ", String.valueOf(advAE), 3, 2));
      this.append(this.advBM = new TextField("Khu danh vong: ", String.valueOf(advAF), 3, 0));
      this.append(this.advAX = new TextField("Map LTD (nv danh quai): ", String.valueOf(advAJ), 3, 2));
      this.append(this.advBC = new ChoiceGroup("Auto mua do?", 1, new String[]{"Ko tu mua", "Duoi 4X", "Duoi 5X", "Duoi 6X", "Duoi 7X", "Mua tat ca"}, (Image[]) null));
      this.append(this.advBB = new ChoiceGroup("NV nang cap TB?", 1, new String[]{"Huy nhiem vu", "Dung auto", "Nhan va lam"}, (Image[]) null));
      this.append(this.advBD = new ChoiceGroup("Neu thieu item thi?", 1, new String[]{"Dung auto", "Huy nhiem vu"}, (Image[]) null));
      this.append(this.advBG = new ChoiceGroup("Nhiem vu TA TL?", 2, new String[]{"Huy nv danh TA", "Huy nv danh TL", "Huy nv loi dai"}, (Image[]) null));
      this.append(this.advBE = new ChoiceGroup("Nhiem vu danh quai?", 1, new String[]{"Bo qua boss", "Bem het"}, (Image[]) null));
      this.append(this.advBH = new TextField("Auto danh vong phu: ", String.valueOf(advAR), 1, 2));
      this.append(this.advBF = new ChoiceGroup("Acc phu thua LD", 2, new String[]{"Tu thoat ra vao lai"}, (Image[]) null));
      super.insert(12, this.advAY);
      super.insert(13, this.advAZ);

      super.addCommand(this.advBN = new Command("Save", 4, 1));
      super.addCommand(new Command("Cancel", 3, 1));
      super.setCommandListener(this);
      // ItemStateListener not available in V8 stubs
      this.advBA.setSelectedIndex(isADanhVong ? 0 : 1, true);
      this.advBC.setSelectedIndex(advAN, true);
      this.advBB.setSelectedIndex(advAK, true);
      this.advBD.setSelectedIndex(advAO, true);
      this.advBE.setSelectedIndex(advAP, true);
      this.advBF.setSelectedIndex(0, advAQ);
      this.advBG.setSelectedIndex(0, advAS);
      this.advBG.setSelectedIndex(1, advAT);
      this.advBG.setSelectedIndex(2, huyNvLoiDai);
   }

   public final void commandAction(Command var1, Displayable var2) {
      if (var1 == this.advBN) {
         try {
            label185: {
               if (isADanhVong = this.advBA.getSelectedIndex() == 0) {
                  label183: {
                     int var14 = Integer.parseInt(this.advAV.getString());
                     int var16 = Integer.parseInt(this.advAW.getString());
                     if (var14 >= 0 && var14 <= 23) {
                        if (var16 >= 0 && var16 <= 59) {
                           advAH = var14;
                           advAI = var16;
                           break label183;
                        }

                        Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Loi", "Phut phai tu 0 den 59", (Image) null, AlertType.ERROR));
                        return;
                     }

                     Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Loi", "Gio phai tu 0 den 23", (Image) null, AlertType.ERROR));
                     return;
                  }
               }

               advAG = Integer.parseInt(this.advAU.getString());
               advAJ = Short.parseShort(this.advAX.getString());
               advAN = (byte) this.advBC.getSelectedIndex();
               advAK = (byte) this.advBB.getSelectedIndex();
               advAL = Byte.parseByte(this.advAY.getString());
               advAM = Integer.parseInt(this.advAZ.getString());
               advAB = this.advBI.getString().trim();
               advAC = Integer.parseInt(this.advBJ.getString());
               advAD = Integer.parseInt(this.advBK.getString());
               advAE = Integer.parseInt(this.advBL.getString());
               advAF = Integer.parseInt(this.advBM.getString());
               advAO = (byte) this.advBD.getSelectedIndex();
               advAP = (byte) this.advBE.getSelectedIndex();
               advAQ = this.advBF.isSelected(0);
               advAR = Byte.parseByte(this.advBH.getString());
               advAS = this.advBG.isSelected(0);
               advAT = this.advBG.isSelected(1);
               huyNvLoiDai = this.advBG.isSelected(2);
               if (!TileMap.isTruong(advAC)) {
                  Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Loi", "Map loi dai phai la map Truong!", (Image) null, AlertType.ERROR));
                  return;
               }

               if (advAR > 6) {
                  advAR = 6;
               }

               if (advAQ && Code.advAH != null) {
                  Code.advAH.advAA = false;
               }

               if (advAC == 0) {
                  advAC = -1;
               }

               if (!TileMap.isLang(advAJ) && !TileMap.isTruong(advAJ)) {
                  advAJ = -1;
               }

               ByteArrayOutputStream var15 = new ByteArrayOutputStream();
               DataOutputStream var17 = new DataOutputStream(var15);

               try {
                  var17.writeUTF(advAB);
                  var17.writeInt(advAC);
                  var17.writeInt(advAD);
                  var17.writeInt(advAE);
                  var17.writeInt(advAF);
                  var17.writeInt(advAG);
                  var17.writeInt(advAH);
                  var17.writeInt(advAI);
                  var17.writeBoolean(isADanhVong);
                  var17.writeShort(advAJ);
                  var17.writeByte(advAN);
                  var17.writeByte(advAK);
                  var17.writeByte(advAL);
                  var17.writeByte(advAO);
                  var17.writeInt(advAM);
                  var17.writeByte(advAP);
                  var17.writeBoolean(advAQ);
                  var17.writeByte(advAR);
                  var17.writeBoolean(advAS);
                  var17.writeBoolean(advAT);
                  var17.writeBoolean(huyNvLoiDai);
                  RMS.saveRMS("chipAutodv", var15.toByteArray());
                  Code.advCC = -1;
                  Code.popup_chat("Luu cai dat DV thanh cong");
                  if (DEBUG_DV) ;
                  var17.flush();
                  var15.flush();
                  break label185;
               } catch (Exception var11) {
                  Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Loi", "Co loi xay ra. Hay xem lai cai dat!", (Image) null, AlertType.ERROR));
               } finally {
                  try {
                     var15.close();
                     var17.close();
                  } catch (IOException var10) {
                  }
               }

               return;
            }
         } catch (Exception var13) {
            Display.getDisplay(GameMidlet.g).setCurrent(new Alert("Loi", "Co loi xay ra. Hay xem lai cai dat!", (Image) null, AlertType.ERROR));
            return;
         }
      }

      Display.getDisplay(GameMidlet.g).setCurrent(MotherCanvas.a);
   }

   // itemStateChanged removed: ItemStateListener not available in V8 stubs
}
