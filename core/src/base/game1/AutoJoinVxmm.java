package base.game1;



public class AutoJoinVxmm implements Runnable {

    public void run() {
        MyVector var1 = ModelVxmm.GetPlayer();

        for (int var2 = 0; var2 < var1.size(); ++var2) {
            if (!Code.isAutoVxmm) {
                Code.popup_chat("Dừng auto thuê bot.");
                return;
            }

            String var3;
            var3 = (String) var1.elementAt(var2);
            var3 = var3.substring(var3.indexOf(".") + 1).trim();
            if (phong.CharInMap(var3) != null) {
                int var4;
                if ((var4 = ModelVxmm.getSeconds(var3)) == 5) {
                    var4 = NinjaUtil.randomRange(11, 120);
                }

                ChatManager.d().a(var3, Char.getMyChar().displayName(), "" + var4);
                Service.gI().a(var3, "" + var4);
                Code.checkBot(var3);
            } else {
                Code.popup_chat("Không thấy người tên: " + var3 + " trong khu hiện tại.");
            }
        }

        Code.popup_chat("Đã thuê xong.");
        Code.isAutoVxmm = false;
    }
}
