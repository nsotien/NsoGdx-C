package base.game1;

public final class DichChuyenItem implements Runnable {
    private final Item srcItem;

    DichChuyenItem(Item item) {
        this.srcItem = item;
    }

    public void run() {
        try {
            // Thu thập Chuyển Tinh Thạch (id=454) trong hành trang
            MyVector stones = new MyVector();
            Item[] bag = Char.getMyChar().arrItemBag;
            for (int i = 0; i < bag.length; i++) {
                if (bag[i] != null && bag[i].template.id == 454) {
                    stones.addElement(bag[i]);
                }
            }
            if (stones.size() < 20) {
                GameCanvas.a(TextGame.rs);
                return;
            }
            // Lấy 20 viên, xóa khỏi UI optimistic
            Item[] used = new Item[24];
            for (int i = 0; i < 20; i++) {
                Item s = (Item) stones.elementAt(stones.size() - 1);
                used[i] = s;
                bag[s.indexUI] = null;
                stones.removeElementAt(stones.size() - 1);
            }
            // Set cj + cb cho Controller case 22
            GameScr.cj = srcItem;
            GameScr.cb = used;
            // Gửi packet 112 (item slot + 20 stone slots)
            Service.gI().b(srcItem, used);
            // Set upgrade = 0 ngay để ẩn nút "Dịch Chuyển" — không chờ server
            srcItem.upgrade = 0;
            // Gửi packet 93 (tên nhân vật target đang focus)
            if (Char.getMyChar().charFocus != null) {
                Service.gI().a(Char.getMyChar().charFocus.cName, 0);
            }
            ;
            Thread.sleep(2000L);
        } catch (Exception e) {
            GameCanvas.a("Lỗi dịch chuyển");
            ;
        }
    }
}
