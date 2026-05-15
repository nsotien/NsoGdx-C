package base.game1;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.TimeZone;

public final class AutoDanhVong extends Auto {

    public static int dieukien = -2;
    private static int advAZ;
    private static int advBA;
    private static int danhduoc;
    private static int candanh;
    public static ItemTemplate itemTemplate;
    public static Item advAC = null;
    private static Item advBD = null;
    private static Item advBE = null;
    private static boolean hoanthanh = false;
    private static boolean endauto = false;
    private static boolean advBH = false;
    private static int dadanh = 0;
    private static int phaidanh = 0;
    private static byte indexLanguage = 0;
    private static String[] advBL;
    private static String[] advBM;
    private static String[] advBN;
    private static String[] advBO;
    private static String[] advBP;
    private static String[] advBQ;
    private static String[] advBR;
    private static String[] sudungtb;
    private static String[] tieudiet;
    private static String[] advBU;
    private static String[] advBV;
    private static String[] advBW;
    private static final Object advBX = new Object();
    private static boolean advBY = false;
    private static boolean advBZ = false;
    private static boolean advCA = false;
    private static boolean advCB = false;
    private static boolean advCC = false;
    private static boolean advCD;
    private static byte advCE;
    private static int advCF = -1;
    private TaskOrder advCG;
    public static ItemTemplate itemTemplateup;
    // Port TGAME: co tu sat 1 lan sau khi hoan thanh NVDV (khi chua o lang/truong)
    private boolean advCI = false;
    // Port TGAME: co tu sat 1 lan khi bat dau DV (khi chua o lang/truong) de ve nhanh
    private boolean advCH = false;
    // PLAN_AUTO_DV_KICH_YEN_THEO_NHOM §3: flag da gui remote "ts" cho lan ra
    // map DV hien tai. Reset khi leader roi map DV (auto() top), khi advAW()
    // bat dau phien moi. Tranh spam chat nhom moi tick.
    private static boolean sentGroupTsThisFarm = false;

    // [FIX 11] cooldown 30s giữa 2 lần auto-pick khu ít người khi advAF=-1
    private static long lastAutoPickKhuTime = 0L;

    // --- Port TGAME: Snapshot trang bi dau phien (RAM only) ---
    // Plan: PLAN_AUTO_DV_NHO_TRANG_BI.md §4.1
    private static final int EQ_SLOT_COUNT = 16;
    private Item[] advEqSnapshotRef;        // Lop 1: object reference
    private short[] advEqSnapFpId;          // Lop 2: fingerprint id
    private byte[]  advEqSnapFpUpgrade;
    private boolean[] advEqSnapFpLock;
    private boolean[] advEqSnapFpExpires;
    private int[]   advEqSnapFpSys;
    private boolean[] advEqSnapHasItem;
    private int     advEqSnapDay = -1;
    private boolean advEqSnapCaptured = false;
    private boolean advEqRestoring = false;

    // --- Helper: find item in box by template id ---
    private static Item findItemBox(int id) {
        if (Char.getMyChar().arrItemBox == null) {
            Service.gI().i(4);
            LockGame.advAS();
            if (FormDanhVong.DEBUG_DV) ;
        }
        Item[] box = Char.getMyChar().arrItemBox;
        if (box == null) return null; // box van null sau timeout → ko co item
        for (int i = 0; i < box.length; ++i) {
            Item it;
            if ((it = box[i]) != null && it.template.id == id) {
                return it;
            }
        }
        return null;
    }

    // --- Helper: count crystal value in bag ---
    private static int countCrystalValue() {
        Item[] bag = Char.getMyChar().arrItemBag;
        int total = 0;
        for (int i = 0; i < bag.length; ++i) {
            Item it;
            if ((it = bag[i]) != null && it.template.type == 26 && it.template.id <= 4) {
                total += GameScr.cx[it.template.id];
            }
        }
        return total;
    }

    // --- Helper: get Calendar with timezone ---
    private static Calendar getCalendar(int lang) {
        Calendar cal = Calendar.getInstance();
        if (lang == 0) {
            cal.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        }
        return cal;
    }

    // --- Helper: find ItemTemplate by name and gender ---
    // V8 ItemTemplate.name co suffix " (ID)" vd "Bùa Kháng Ma (175)"
    // Server gui ten ko co suffix vd "Bùa Kháng Ma"
    // → startsWith(name + " (") de match chinh xac ten + dau suffix ID
    private static ItemTemplate findItemTemplate(String name, byte gender) {
        if (FormDanhVong.DEBUG_DV) ;
        String nameWithSuffix = name + " (";
        // Lan 1: match chat — ten + " (" (tranh match prefix ngan)
        Enumeration en = ItemTemplates.a.a.elements();
        while (en.hasMoreElements()) {
            ItemTemplate it = (ItemTemplate) en.nextElement();
            if (it.name != null && (it.name.startsWith(nameWithSuffix) || it.name.equals(name))
                && (it.gender == 2 || it.gender == gender)) {
                if (FormDanhVong.DEBUG_DV) ;
                return it;
            }
        }
        // Lan 2: fallback bo 1 ky tu cuoi ten (space thua — giong ref var5)
        if (name.length() > 1) {
            String trimmed = name.substring(0, name.length() - 1);
            String trimmedWithSuffix = trimmed + " (";
            en = ItemTemplates.a.a.elements();
            while (en.hasMoreElements()) {
                ItemTemplate it = (ItemTemplate) en.nextElement();
                if (it.name != null && (it.name.startsWith(trimmedWithSuffix) || it.name.equals(trimmed))
                    && (it.gender == 2 || it.gender == gender)) {
                    if (FormDanhVong.DEBUG_DV) ;
                    return it;
                }
            }
        }
        // Lan 3: fallback startsWith long (backward compat)
        en = ItemTemplates.a.a.elements();
        while (en.hasMoreElements()) {
            ItemTemplate it = (ItemTemplate) en.nextElement();
            if (it.name != null && it.name.startsWith(name) && (it.gender == 2 || it.gender == gender)) {
                if (FormDanhVong.DEBUG_DV) ;
                return it;
            }
        }
        if (FormDanhVong.DEBUG_DV) ;
        return null;
    }

    // --- Helper: isTypeClothe ---
    private static boolean isTypeClothe(Item item) {
        return item.template.type == 0 || item.template.type == 2 || item.template.type == 4 || item.template.type == 6 || item.template.type == 8;
    }

    // --- Helper: isTypeAdorn ---
    private static boolean isTypeAdorn(Item item) {
        return item.template.type == 3 || item.template.type == 5 || item.template.type == 7 || item.template.type == 9;
    }

    // --- Helper: isTypeWeapon ---
    private static boolean isTypeWeapon(Item item) {
        return item.template.type == 1;
    }

    public static void advAA() {
        advBY = true;
        synchronized (advBX) {
            try {
                advBX.wait(2000L);
            } catch (InterruptedException var2) {
            }
        }
    }

    public static void advAB() {
        if (advBY) {
            synchronized (advBX) {
                advBX.notifyAll();
            }
            advBY = false;
        }
    }

    private static boolean advAU() {
        advCC = true;
        long var0 = System.currentTimeMillis();
        synchronized (advBX) {
            try {
                advBX.wait(5000L);
            } catch (InterruptedException var3) {
            }
        }
        return System.currentTimeMillis() - var0 < 5000L;
    }

    public static void advAC() {
        if (advCC) {
            synchronized (advBX) {
                advBX.notifyAll();
            }
            advCC = false;
        }
    }

    private static boolean advAV() {
        advBZ = true;
        long var0 = System.currentTimeMillis();
        synchronized (advBX) {
            try {
                advBX.wait(5000L);
            } catch (InterruptedException var3) {
            }
        }
        return System.currentTimeMillis() - var0 < 5000L;
    }

    public static void advAD() {
        if (advBZ) {
            synchronized (advBX) {
                advBX.notifyAll();
            }
            advBZ = false;
        }
    }

    // Port TGAME: sau khi hoan thanh NVDV, tu sat 1 lan de ve lang/truong tra Ameji,
    // tranh spam tu sat moi tick + tranh vong lap lang thang giua map.
    private boolean tryFastReturnOnComplete() {
        if (!hoanthanh || this.advCI || TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID)) {
            return false;
        }

        this.advCI = true;
        Auto.tusat_vdmq();
        return true;
    }

    // Port TGAME: yeu cau tu sat 1 lan ngay khi bat dau DV de ve lang/truong nhanh,
    // khong phai chay bo tu map farm ve. Set flag, tick dau cua auto() se thuc thi.
    public final void requestFastReturnOnStart() {
        this.advCH = true;
    }

    private boolean tryFastReturnOnStart() {
        if (!this.advCH) {
            return false;
        }

        this.advCH = false;
        if (TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID)) {
            return false;
        }

        Auto.tusat_vdmq();
        return true;
    }

    public static boolean advAE() {
        advCA = true;
        long var0 = System.currentTimeMillis();
        synchronized (advBX) {
            try {
                advBX.wait(5000L);
            } catch (InterruptedException var3) {
            }
        }
        return System.currentTimeMillis() - var0 < 5000L;
    }

    public static void advAF() {
        if (advCA) {
            synchronized (advBX) {
                advBX.notifyAll();
            }
            advCA = false;
        }
    }

    public static boolean advAG() {
        advCB = true;
        long var0 = System.currentTimeMillis();
        synchronized (advBX) {
            try {
                advBX.wait(5000L);
            } catch (InterruptedException var3) {
            }
        }
        return System.currentTimeMillis() - var0 < 5000L;
    }

    public static void advAH() {
        if (advCB) {
            synchronized (advBX) {
                advBX.notifyAll();
            }
            advCB = false;
        }
    }

    public final void reset() {
        super.reset();
        this.advAW();
        // Port TGAME: clear snapshot khi user chủ động trigger lại để force re-capture theo bộ hiện tại
        this.clearOriginalEquipmentSnapshot();
    }

    // =====================================================================
    // Port TGAME: Snapshot trang bi dau phien - Plan §5.1, §5.6
    // =====================================================================

    // Goi o tick dau cua auto(). Capture 1 lan/phien. Qua ngay moi -> re-capture.
    private void prepareOriginalEquipmentSnapshot() {
        if (Char.getMyChar() == null || Char.getMyChar().arrItemBody == null) {
            return;
        }
        int today = getCalendar(indexLanguage).get(5);
        if (this.advEqSnapCaptured) {
            if (this.advEqSnapDay == today) {
                return; // giu nguyen snapshot
            }
            // qua ngay moi -> clear, chup lai theo bo dang mac
            this.clearOriginalEquipmentSnapshot();
        }
        this.captureOriginalEquipmentNow(today);
    }

    private void captureOriginalEquipmentNow(int today) {
        this.advEqSnapshotRef    = new Item[EQ_SLOT_COUNT];
        this.advEqSnapFpId       = new short[EQ_SLOT_COUNT];
        this.advEqSnapFpUpgrade  = new byte[EQ_SLOT_COUNT];
        this.advEqSnapFpLock     = new boolean[EQ_SLOT_COUNT];
        this.advEqSnapFpExpires  = new boolean[EQ_SLOT_COUNT];
        this.advEqSnapFpSys      = new int[EQ_SLOT_COUNT];
        this.advEqSnapHasItem    = new boolean[EQ_SLOT_COUNT];

        Item[] body = Char.getMyChar().arrItemBody;
        for (int i = 0; i < EQ_SLOT_COUNT; ++i) {
            Item it = (body != null && i < body.length) ? body[i] : null;
            if (it != null && it.template != null) {
                this.advEqSnapshotRef[i]   = it;
                this.advEqSnapFpId[i]      = (short) it.template.id;
                this.advEqSnapFpUpgrade[i] = (byte) it.upgrade;
                this.advEqSnapFpLock[i]    = it.isLock;
                this.advEqSnapFpExpires[i] = it.isExpires;
                this.advEqSnapFpSys[i]     = it.sys;
                this.advEqSnapHasItem[i]   = true;
            } else {
                this.advEqSnapHasItem[i]   = false;
            }
        }
        this.advEqSnapDay = today;
        this.advEqSnapCaptured = true;
    }

    private void clearOriginalEquipmentSnapshot() {
        this.advEqSnapshotRef   = null;
        this.advEqSnapFpId      = null;
        this.advEqSnapFpUpgrade = null;
        this.advEqSnapFpLock    = null;
        this.advEqSnapFpExpires = null;
        this.advEqSnapFpSys     = null;
        this.advEqSnapHasItem   = null;
        this.advEqSnapCaptured  = false;
    }

    // Cờ guard cho Code.java (§7 plan). Chỉ true khi AutoDanhVong hiện tại đang restore.
    public static boolean isRestoringOriginalEquipment() {
        Auto m = Code.mode;
        if (m instanceof AutoDanhVong) {
            return ((AutoDanhVong) m).advEqRestoring;
        }
        return false;
    }

    // =====================================================================
    // Port TGAME: Match helpers - Plan §3, §6.1
    // =====================================================================

    // Lớp 1: object reference
    private static Item findByRefInArray(Item ref, Item[] arr) {
        if (ref == null || arr == null) return null;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == ref) return arr[i];
        }
        return null;
    }

    // Lớp 2: fingerprint match
    private boolean fingerprintMatchAt(int slot, Item cand) {
        if (cand == null || cand.template == null) return false;
        return cand.template.id == this.advEqSnapFpId[slot]
            && cand.upgrade    == (this.advEqSnapFpUpgrade[slot] & 0xFF)
            && cand.isLock     == this.advEqSnapFpLock[slot]
            && cand.isExpires  == this.advEqSnapFpExpires[slot]
            && cand.sys        == this.advEqSnapFpSys[slot];
    }

    private Item findByFingerprint(int slot, Item[] arr) {
        if (arr == null) return null;
        for (int i = 0; i < arr.length; ++i) {
            if (fingerprintMatchAt(slot, arr[i])) return arr[i];
        }
        return null;
    }

    private boolean slotAlreadyMatches(int slot) {
        Item[] body = Char.getMyChar().arrItemBody;
        Item cur = (body != null && slot < body.length) ? body[slot] : null;
        if (cur == null) return false;
        if (cur == this.advEqSnapshotRef[slot]) return true;
        return fingerprintMatchAt(slot, cur);
    }

    private Item locateInBag(int slot) {
        Item[] bag = Char.getMyChar().arrItemBag;
        Item byRef = findByRefInArray(this.advEqSnapshotRef[slot], bag);
        if (byRef != null) return byRef;
        return findByFingerprint(slot, bag);
    }

    private Item locateInBox(int slot) {
        Item[] box = Char.getMyChar().arrItemBox;
        Item byRef = findByRefInArray(this.advEqSnapshotRef[slot], box);
        if (byRef != null) return byRef;
        return findByFingerprint(slot, box);
    }

    // =====================================================================
    // Port TGAME: Restore helpers - Plan §6.1, §6.2, §6.3
    // =====================================================================

    // Đảm bảo bag còn ít nhất 1 ô trống. Nếu full, cất tạm 1 món không thuộc snapshot và không phải item quest.
    private boolean ensureBagHasFreeSlot() {
        if (Code.solg_hanhtrang() > 0) return true;

        if (Char.getMyChar().arrItemBox == null) {
            Service.gI().i(4);
            LockGame.advAS();
        }
        if (Char.getMyChar().arrItemBox == null) return false;

        GameScr.pickNPC(5, 0, 0);
        if (advAE()) {
            GameScr.pickNPC(5, 0, 0);
        }
        if (!advAG()) return false;

        Item[] bag = Char.getMyChar().arrItemBag;
        if (bag == null) return false;
        for (int i = 0; i < bag.length; ++i) {
            Item it = bag[i];
            if (it == null || it.template == null) continue;
            // không cất item quest hiện tại
            if (itemTemplate != null && it.template.id == itemTemplate.id) continue;
            // không cất item là 1 phần của snapshot (cùng fingerprint với slot nào đó)
            boolean isSnap = false;
            if (this.advEqSnapshotRef != null) {
                for (int s = 0; s < EQ_SLOT_COUNT; ++s) {
                    if (!this.advEqSnapHasItem[s]) continue;
                    if (it == this.advEqSnapshotRef[s] || fingerprintMatchAt(s, it)) {
                        isSnap = true;
                        break;
                    }
                }
            }
            if (isSnap) continue;

            // cất tạm
            Service.gI().e(it.indexUI);
            advAA();
            if (Code.solg_hanhtrang() > 0) return true;
        }
        return Code.solg_hanhtrang() > 0;
    }

    // Poll arrItemBody[slot] theo điều kiện trong giới hạn thời gian.
    // mode 0 = chờ slot body = null; mode 1 = chờ slot body = target Item (hoặc fingerprint match)
    private boolean pollBodySlot(int slot, int mode, Item target) {
        for (int i = 0; i < 20; ++i) { // ~ 20 * 150ms = 3s
            Item[] body = Char.getMyChar().arrItemBody;
            Item cur = (body != null && slot < body.length) ? body[slot] : null;
            if (mode == 0 && cur == null) return true;
            if (mode == 1) {
                if (cur == target) return true;
                if (cur != null && fingerprintMatchAt(slot, cur)) return true;
            }
            phong.sleep(150L);
        }
        return false;
    }

    // Restore 1 slot có snapshot. Return true nếu slot khớp snapshot sau khi thực thi.
    private boolean restoreOneSlot(int slot) {
        if (slotAlreadyMatches(slot)) return true;

        // Tìm target trong bag trước
        Item target = locateInBag(slot);
        if (target != null) {
            Service.gI().useItem(target.indexUI);
            LockGame.advAQ();
            return pollBodySlot(slot, 1, target);
        }

        // Không ở bag -> tìm trong box
        if (Char.getMyChar().arrItemBox == null) {
            Service.gI().i(4);
            LockGame.advAS();
        }
        target = locateInBox(slot);
        if (target == null) return false;

        if (!ensureBagHasFreeSlot()) return false;

        GameScr.pickNPC(5, 0, 0);
        if (advAE()) {
            GameScr.pickNPC(5, 0, 0);
        }
        if (!advAG()) return false;

        Service.gI().d(target.indexUI); // box -> bag
        advAV();

        Item bagItem = locateInBag(slot);
        if (bagItem == null) return false;
        Service.gI().useItem(bagItem.indexUI);
        LockGame.advAQ();
        return pollBodySlot(slot, 1, bagItem);
    }

    // Slot snapshot null nhưng hiện tại có item -> thao xuống bag.
    private boolean clearOneSlot(int slot) {
        Item[] body = Char.getMyChar().arrItemBody;
        if (body == null || slot >= body.length || body[slot] == null) return true;
        if (!ensureBagHasFreeSlot()) return false;
        Service.gI().b(slot); // unequip body -> bag
        return pollBodySlot(slot, 0, null);
    }

    // =====================================================================
    // Port TGAME: Pha restore cuối phiên - Plan §5.3
    // =====================================================================

    // Trả về null nếu OK, trả về tên slot/item bị thiếu nếu FAIL.
    private String restoreOriginalEquipmentBeforeExit() {
        if (!this.advEqSnapCaptured || this.advEqSnapshotRef == null) {
            return null; // không có snapshot -> nothing to do
        }

        this.advEqRestoring = true;
        try {
            if (FormDanhVong.advAJ > 0
                    && (TileMap.isLang(FormDanhVong.advAJ) || TileMap.isTruong(FormDanhVong.advAJ))) {
                if (TileMap.mapID != FormDanhVong.advAJ) {
                    this.remap(FormDanhVong.advAJ, -2, -1, -1);
                }
                GameScr.pickNPC(5, 1, 0);
                if (LockGame.advAY()) {
                    phong.sleep(1000L);
                }
            }

            if (Char.getMyChar().arrItemBox == null) {
                Service.gI().i(4);
                LockGame.advAS();
            }

            // Restore slot có item trước, slot null sau
            for (int i = 0; i < EQ_SLOT_COUNT; ++i) {
                if (!this.advEqSnapHasItem[i]) continue;
                if (!restoreOneSlot(i)) {
                    return describeSnapshotSlot(i);
                }
            }
            for (int i = 0; i < EQ_SLOT_COUNT; ++i) {
                if (this.advEqSnapHasItem[i]) continue;
                if (!clearOneSlot(i)) {
                    return "slot " + i + " (cần để trống)";
                }
            }

            // Verify cuối
            for (int i = 0; i < EQ_SLOT_COUNT; ++i) {
                Item[] body = Char.getMyChar().arrItemBody;
                Item cur = (body != null && i < body.length) ? body[i] : null;
                if (this.advEqSnapHasItem[i]) {
                    if (cur == null || (cur != this.advEqSnapshotRef[i] && !fingerprintMatchAt(i, cur))) {
                        return describeSnapshotSlot(i);
                    }
                } else {
                    if (cur != null) return "slot " + i + " (cần để trống)";
                }
            }
            return null;
        } finally {
            this.advEqRestoring = false;
        }
    }

    private String describeSnapshotSlot(int slot) {
        if (this.advEqSnapshotRef != null
                && this.advEqSnapshotRef[slot] != null
                && this.advEqSnapshotRef[slot].template != null
                && this.advEqSnapshotRef[slot].template.name != null) {
            return this.advEqSnapshotRef[slot].template.name;
        }
        return "slot " + slot + " (id=" + (this.advEqSnapFpId == null ? 0 : this.advEqSnapFpId[slot])
                + " +" + (this.advEqSnapFpUpgrade == null ? 0 : (this.advEqSnapFpUpgrade[slot] & 0xFF)) + ")";
    }

    // Gọi tại 2 exit point thay cho remap+mởkho+remode cũ.
    // Trả về true nếu đã xử lý xong (success hoặc fail với popup), caller nên return ngay.
    private boolean finalizeSessionWithRestore(boolean needSleepBefore) {
        if (needSleepBefore) phong.sleep(3000L);

        String missing = restoreOriginalEquipmentBeforeExit();
        if (missing != null) {
            Code.popup_chat("Không tìm thấy trang bị mặc: " + missing
                    + " — auto đã dừng. Đặt món vào bag/rương rồi chat 'adv' lại.");
            // KHÔNG clearOriginalEquipmentSnapshot() — giữ snapshot để retry
            // KHÔNG remode() — không quay lại up với bộ đồ sai
            Code.mode = null;
            LockGame.advBK();
            return true;
        }

        // Thành công -> clear snapshot và remode
        this.clearOriginalEquipmentSnapshot();

        if (super.mode_temp != null && !(super.mode_temp instanceof AutoDanhVong)) {
            Auto oldMode = super.mode_temp;
            boolean recallGroup = oldMode instanceof AutoTansat
                    && oldMode.danh_nhom
                    && Auto.isLeader()
                    && GameScr.vParty.size() > 1
                    && oldMode.map_auto > 0;
            Code.remode();
            if (recallGroup) {
                AutoTansat tsMode = (AutoTansat) oldMode;
                Code.callGroupTsRemote(oldMode.map_auto, oldMode.khu_auto, tsMode.id);
            }
        } else {
            Code.mode = null;
            LockGame.advBK();
        }
        return true;
    }

    private void advAW() {
        dieukien = -2;
        advBE = null;
        advAC = null;
        advBD = null;
        hoanthanh = false;
        endauto = false;
        advBH = false;
        advCD = false;
        this.advCI = false;
        this.advCH = false;
        sentGroupTsThisFarm = false;
        lastAutoPickKhuTime = 0L;   // [FIX 11] reset để pick khu ngay khi start
        advAF();
        advAH();
        advAD();
        advAC();
        if (FormDanhVong.advAE <= 0) {
            this.advCG = Char.get_nvhn(0);
        } else {
            super.isPhoban = TileMap.isPhuBan(FormDanhVong.advAE);
        }

        // Language detection: default Vietnamese, server quốc tế → English
        indexLanguage = 0;
        if (GameMidlet.d != null && (GameMidlet.d.equals(advBL[0]) || GameMidlet.d.equals(advBL[1]))) {
            indexLanguage = 1;
        }

        if (advCF == -1) {
            advAZ = 0;
            advBA = 0;
            advCE = 0;
            advCF = getCalendar(indexLanguage).get(5);
        } else {
            int var1;
            if ((var1 = getCalendar(indexLanguage).get(5)) != advCF) {
                advAZ = 0;
                advBA = 0;
                advCE = 0;
                advCF = var1;
            }
        }
        if (FormDanhVong.DEBUG_DV) ;
    }

    private static int advAB(byte var0) {
        if (var0 > 0 && var0 < 20) {
            return 4;
        } else if (var0 >= 20 && var0 < 40) {
            return 8;
        } else if (var0 >= 40 && var0 < 50) {
            return 12;
        } else {
            return var0 >= 50 && var0 < 60 ? 14 : 16;
        }
    }

    public static void advAA(String var0) {
        if (FormDanhVong.DEBUG_DV) ;
        if (dieukien >= 0) {
            if (var0.startsWith("-") || var0.indexOf(advBM[indexLanguage]) != -1) {
                itemTemplate = null;
                hoanthanh = false;
                dieukien = -1;
                if (FormDanhVong.DEBUG_DV) ;
                LockGame.notifyDV();
                return;
            }
        } else {
            if (dieukien == -2 && var0.startsWith(advBN[indexLanguage])) {
                itemTemplate = null;
                dieukien = -1;
                if (FormDanhVong.DEBUG_DV) ;
                LockGame.notifyDV();
                return;
            }

            hoanthanh = false;
            if (Code.mode instanceof AutoDanhVong) {
                ((AutoDanhVong) Code.mode).advCI = false;
            }
            String[] data = Code.split_string(var0, "\n");
            if (FormDanhVong.DEBUG_DV) ;
            if (data[0].equals(advBO[indexLanguage])) {
                dieukien = 1;
            } else if (data[0].equals(advBP[indexLanguage]) && !FormDanhVong.advAS) {
                dieukien = 2;
            } else if (data[0].equals(advBQ[indexLanguage]) && !FormDanhVong.advAT) {
                dieukien = 3;
            } else if (data[0].startsWith(advBV[indexLanguage]) && FormDanhVong.advAK != 0) {
                dieukien = 4;
            } else if (data[0].equals(advBR[indexLanguage]) && !FormDanhVong.huyNvLoiDai) {
                dieukien = 5;
            } else {
                dieukien = 0;
            }

            if (FormDanhVong.DEBUG_DV) ;

            if (dieukien != 0) {
                String substring;
                String trim;
                int index;
                String substring2;
                String substring3;
                if (dieukien < 4) {
                    if (FormDanhVong.DEBUG_DV) {
                        ;
                        ;
                    }
                    if (data[1].startsWith("- Sử dụng ") && data[2].startsWith("- Tiêu diệt ")) {
                        substring = cleanItemName(data[1].substring(10));
                        trim = data[2].substring(12).trim();
                        // V8: "0/500 quái lệch 10 cấp độ." — parse "0" va "500" bang split "/"
                        index = trim.indexOf(47); // '/'
                        substring2 = trim.substring(0, index);
                        // Tim space SAU "/" de lay max value (ko dung indexOf(32) vi co the nhieu space)
                        int spaceAfterSlash = trim.indexOf(32, index);
                        substring3 = spaceAfterSlash > 0 ? trim.substring(index + 1, spaceAfterSlash) : trim.substring(index + 1);
                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            if (FormDanhVong.DEBUG_DV) ;
                            itemTemplate = findItemTemplate(substring, (byte) Char.getMyChar().cgender);
                            if (itemTemplate == null) {
                                if (FormDanhVong.DEBUG_DV) ;
                                throw new Exception("item not found: " + substring);
                            }
                            if (FormDanhVong.DEBUG_DV) ;
                            if (checkHoanThanh(data)) {
                                hoanthanh = true;
                            } else {
                                advCD = false;
                            }
                        } catch (Exception var11) {
                            Code.popup_chat("Loi nv!");
                            endauto = true;
                        }
                    } else {
                        Code.popup_chat("Loi nv!");
                        endauto = true;
                    }
                } else if (dieukien == 4) {
                    if (FormDanhVong.DEBUG_DV) {
                        ;
                        if (data.length > 2) ;
                    }
                    // V8 server type 0 (nang cap): data[1] = "- Nâng cấp trang bị ItemName lên cấp step/max"
                    // KHONG co "- Sử dụng" line rieng — all-in-one format
                    if (data[1].startsWith("- Nâng cấp trang bị ")) {
                        // Parse: "- Nâng cấp trang bị Bùa Kháng Ma lên cấp 3/8"
                        trim = data[1].substring(20); // bo "- Nâng cấp trang bị " (20 chars)
                        int lenCapIdx = trim.indexOf(" lên cấp ");
                        if (lenCapIdx > 0) {
                            substring = trim.substring(0, lenCapIdx); // item name
                            String progressPart = trim.substring(lenCapIdx + 9); // "3/8"
                            index = progressPart.indexOf(47); // '/'
                            substring2 = progressPart.substring(0, index);
                            substring3 = progressPart.substring(index + 1).trim();
                        } else {
                            if (FormDanhVong.DEBUG_DV) ;
                            Code.popup_chat("Loi nv!");
                            endauto = true;
                            return;
                        }
                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            if (FormDanhVong.DEBUG_DV) ;
                            itemTemplate = findItemTemplate(substring, (byte) Char.getMyChar().cgender);
                            if (itemTemplate == null) {
                                if (FormDanhVong.DEBUG_DV) ;
                                throw new Exception("item not found: " + substring);
                            }
                            itemTemplateup = itemTemplate;
                            if (FormDanhVong.DEBUG_DV) ;
                            if (checkHoanThanh(data)) {
                                hoanthanh = true;
                            } else if (advAB(itemTemplate.level) < candanh) {
                                dieukien = 0;
                                if (FormDanhVong.DEBUG_DV) ;
                            }
                        } catch (Exception var10) {
                            if (FormDanhVong.DEBUG_DV) ;
                            Code.popup_chat("Loi nv!");
                            endauto = true;
                        }
                    } else if (data[1].startsWith("- Sử dụng ") && data.length > 2 && data[2].startsWith("- Nâng cấp ")) {
                        // Fallback: NSOZ format (2 dong rieng)
                        substring = cleanItemName(data[1].substring(10));
                        trim = data[2].substring(11).trim();
                        index = trim.indexOf(47);
                        substring2 = trim.substring(0, index);
                        int spaceAfterSlash4 = trim.indexOf(32, index);
                        substring3 = spaceAfterSlash4 > 0 ? trim.substring(index + 1, spaceAfterSlash4) : trim.substring(index + 1);
                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            itemTemplate = findItemTemplate(substring, (byte) Char.getMyChar().cgender);
                            if (itemTemplate == null) throw new Exception("item not found: " + substring);
                            itemTemplateup = itemTemplate;
                            if (checkHoanThanh(data)) {
                                hoanthanh = true;
                            } else if (advAB(itemTemplate.level) < candanh) {
                                dieukien = 0;
                            }
                        } catch (Exception var10) {
                            Code.popup_chat("Loi nv!");
                            endauto = true;
                        }
                    } else {
                        if (FormDanhVong.DEBUG_DV) ;
                        Code.popup_chat("Loi nv!");
                        endauto = true;
                    }
                } else if (dieukien == 5) {
                    if (FormDanhVong.DEBUG_DV) {
                        ;
                        ;
                        ;
                        ;
                    }
                    if (data[1].startsWith("- Sử dụng ") && data[2].startsWith("- Chiến thắng ")) {
                        substring = cleanItemName(data[1].substring(10));
                        index = (trim = data[2].substring(14).trim()).indexOf(47);
                        substring2 = trim.substring(0, index);
                        int spaceAfterSlash5 = trim.indexOf(32, index);
                        substring3 = spaceAfterSlash5 > 0 ? trim.substring(index + 1, spaceAfterSlash5) : trim.substring(index + 1);

                        try {
                            dadanh = danhduoc = Integer.parseInt(substring2);
                            phaidanh = candanh = Integer.parseInt(substring3);
                            if (FormDanhVong.DEBUG_DV) ;
                            if ((itemTemplate = findItemTemplate(substring, (byte) Char.getMyChar().cgender)) == null) {
                                if (FormDanhVong.DEBUG_DV) ;
                                throw new Exception("item not found: " + substring);
                            }

                            if (FormDanhVong.DEBUG_DV) ;
                            if (checkHoanThanh(data)) {
                                hoanthanh = true;
                            } else {
                                Code.advAG.reset();
                            }
                        } catch (Exception var8) {
                            if (FormDanhVong.DEBUG_DV) ;
                            Code.popup_chat("Loi nv!");
                            endauto = true;
                        }
                    } else {
                        if (FormDanhVong.DEBUG_DV) ;
                        Code.popup_chat("Loi nv!");
                        endauto = true;
                    }
                }
                // Fix #10: types 6 and 7 removed entirely

                if (itemTemplate != null && itemTemplate.level > Char.getMyChar().cLevel) {
                    dieukien = 0;
                }
            }

            LockGame.notifyDV();
        }

    }

    public static boolean advAB(String var0) {
        if (!var0.equals("Con đã hoàn thành đủ số nhiệm vụ cho ngày hôm nay rồi")) {
            if (var0.equals("Mỗi ngày chỉ có thể sử dụng vật phẩm này 6 lần")) {
                advBH = true;
                advCE = FormDanhVong.advAR;
                return true;
            } else if (var0.equals("Hoàn thành nhiệm vụ, hãy gặp Ameji để trả nhiệm vụ")) {
                danhduoc = candanh;
                dadanh = phaidanh;
                if (dieukien >= 4) {
                    hoanthanh = true;
                }

                if (dieukien <= 4) {
                    advCD = false;
                }

                return true;
            } else {
                int var1;
                int var2;
                if (var0.indexOf(sudungtb[indexLanguage]) != -1) {
                    if (dieukien < 4) {
                        var1 = var0.indexOf(tieudiet[indexLanguage]);
                        var2 = var0.indexOf(47);
                        if (indexLanguage != 0) {
                            var0 = var0.substring(var1 + 7, var2);
                        } else {
                            var0 = var0.substring(var1 + 10, var2);
                        }

                        try {
                            dadanh = Integer.parseInt(var0);
                            danhduoc = dadanh;
                        } catch (NumberFormatException var5) {
                        }
                    } else if (dieukien == 5) {
                        var1 = var0.indexOf(advBU[indexLanguage]);
                        var2 = var0.indexOf(47);
                        if (indexLanguage != 0) {
                            var0 = var0.substring(var1 + 6, var2);
                        } else {
                            var0 = var0.substring(var1 + 14, var2);
                        }

                        try {
                            dadanh = Integer.parseInt(var0);
                            danhduoc = dadanh;
                        } catch (NumberFormatException var4) {
                        }
                    }
                } else if (var0.indexOf(advBV[indexLanguage]) != -1 && dieukien == 4) {
                    var1 = var0.indexOf(advBW[indexLanguage]);
                    var2 = var0.indexOf(47);
                    if (indexLanguage != 0) {
                        var0 = var0.substring(var1 + 9, var2);
                    } else {
                        var0 = var0.substring(var1 + 8, var2);
                    }

                    try {
                        dadanh = Integer.parseInt(var0);
                        danhduoc = dadanh;
                        if (danhduoc >= candanh) {
                            hoanthanh = true;
                        }
                    } catch (NumberFormatException var3) {
                    }
                }

                return true;
            }
        } else {
            advBH = true;
            if (FormDanhVong.advAR > 0 && advCE < FormDanhVong.advAR) {
                Code.popup_chat("Đang kiểm tra danh vọng phù");
            } else {
                Code.popup_chat("Xong");
            }

            return true;
        }
    }

    private boolean advAX() {
        if (FormDanhVong.DEBUG_DV) ;
        byte var1;
        switch (FormDanhVong.advAN) {
            case 0:
                var1 = -1;
                break;
            case 1:
                var1 = 40;
                break;
            case 2:
            default:
                var1 = 50;
                break;
            case 3:
                var1 = 60;
                break;
            case 4:
                var1 = 70;
                break;
            case 5:
                var1 = 0;
        }

        if (var1 < 0 || var1 > 0 && itemTemplate.level >= var1) {
            Code.popup_chat("Thiếu item: " + itemTemplate.name);
            ;
            if (FormDanhVong.advAO != 0) {
                dieukien = 0;
                advCD = true;
                return false;
            } else {
                return true;
            }
        } else if (!TileMap.isTruong(TileMap.mapID)) {
            this.remap(FormDanhVong.advAC, -2, -1, -1);
            return false;
        } else {
            if (FormDanhVong.DEBUG_DV) ;
            if (itemTemplate.type == 1) {
                GameScr.pickNPC(0, 0, 0);
            } else if (itemTemplate.type == 8) {
                GameScr.pickNPC(1, 0, 4);
            } else if (itemTemplate.type == 6) {
                GameScr.pickNPC(1, 0, 3);
            } else if (itemTemplate.type == 4) {
                GameScr.pickNPC(1, 0, 2);
            } else if (itemTemplate.type == 2) {
                GameScr.pickNPC(1, 0, 1);
            } else if (itemTemplate.type == 0) {
                GameScr.pickNPC(1, 0, 0);
            } else if (itemTemplate.type == 9) {
                GameScr.pickNPC(2, 0, 3);
            } else if (itemTemplate.type == 7) {
                GameScr.pickNPC(2, 0, 2);
            } else if (itemTemplate.type == 5) {
                GameScr.pickNPC(2, 0, 1);
            } else if (itemTemplate.type == 3) {
                GameScr.pickNPC(2, 0, 0);
            }

            if (!LockGame.waitDV()) {
                ;
                Code.popup_chat("Lỗi mua item: " + itemTemplate.name);
                return true;
            } else {
                byte var10000 = itemTemplate.type;
                int var2 = Char.getMyChar().cgender;
                Item[] var6;
                switch (var10000) {
                    case 0:
                        var6 = var2 == 1 ? GameScr.bb : GameScr.bc;
                        break;
                    case 1:
                        var6 = GameScr.bp;
                        break;
                    case 2:
                        var6 = var2 == 1 ? GameScr.bd : GameScr.be;
                        break;
                    case 3:
                        var6 = GameScr.bl;
                        break;
                    case 4:
                        var6 = var2 == 1 ? GameScr.bf : GameScr.bg;
                        break;
                    case 5:
                        var6 = GameScr.bm;
                        break;
                    case 6:
                        var6 = var2 == 1 ? GameScr.bh : GameScr.bi;
                        break;
                    case 7:
                        var6 = GameScr.bn;
                        break;
                    case 8:
                        var6 = var2 == 1 ? GameScr.bj : GameScr.bk;
                        break;
                    case 9:
                        var6 = GameScr.bo;
                        break;
                    default:
                        var6 = null;
                }

                Item[] var5 = var6;
                if (var6 == null) {
                    ;
                    Code.popup_chat("Lỗi mua item: " + itemTemplate.name);
                    return true;
                } else {
                    Item var4 = null;

                    for (int var3 = 0; var3 < var5.length; ++var3) {
                        if (var5[var3].template.id == itemTemplate.id) {
                            var4 = var5[var3];
                            break;
                        }
                    }

                    if (var4 != null) {
                        Service.gI().c(var4.typeUI, var4.indexUI);
                        if (LockGame.advAS() && var4.buyCoin > Char.getMyChar().xu) {
                            ;
                            Code.popup_chat("Ko đủ xu mua: " + var4.template.name);
                            return true;
                        }

                        Service.gI().a(var4.typeUI, var4.indexUI, 1);
                        LockGame.advAG();
                        return false;
                    }

                    // Item không có trong shop → hủy NV, nhận NV mới
                    Code.popup_chat("Shop ko có: " + itemTemplate.name);
                    ;
                    dieukien = 0;
                    advCD = true;
                    return false;
                }
            }
        }
    }

    private boolean advAY() {
        if (FormDanhVong.DEBUG_DV) ;
        if ((advBE = Char.getMyChar().arrItemBody[itemTemplate.type]) != null) {
            ;
        }

        if ((advBD = Char.getItem(itemTemplate.id)) != null) {
            ;
            Service.gI().useItem(advBD.indexUI);
            if (LockGame.advAQ()) {
                return false;
            } else {
                advBD = null;
                ;
                return true;
            }
        } else if ((advAC = findItemBox(itemTemplate.id)) != null) {
            ;
            if (Code.solg_hanhtrang() > 0) {
                if (FormDanhVong.DEBUG_DV) ;
                GameScr.pickNPC(5, 0, 0);
                if (advAE()) {
                    if (FormDanhVong.DEBUG_DV) ;
                    GameScr.pickNPC(5, 0, 0);
                }

                if (advAG()) {
                    if (FormDanhVong.DEBUG_DV) ;
                    Service.gI().d(advAC.indexUI);
                    if (advAV()) {
                        // Tim item trong BAG bang template ID (index da doi sau box→bag)
                        Item bagItem = Char.getItem(advAC.template.id);
                        int useIdx = bagItem != null ? bagItem.indexUI : advAC.indexUI;
                        if (FormDanhVong.DEBUG_DV) ;
                        Service.gI().useItem(useIdx);
                        if (LockGame.advAQ()) {
                            phong.sleep(1000L);
                            GameScr.gI().v();
                            return false;
                        }
                    }
                }
            }

            advAC = null;
            ;
            return true;
        } else {
            return this.advAX();
        }
    }

    private boolean advAZ() {
        if ((advAC = findItemBox(itemTemplate.id)) != null) {
            if (advAC.upgrade > candanh && advAC.upgrade > FormDanhVong.advAM) {
                advAC = null;
                return this.advAX();
            } else {
                ;
                if (Code.solg_hanhtrang() > 0) {
                    GameScr.pickNPC(5, 0, 0);
                    if (advAE()) {
                        GameScr.pickNPC(5, 0, 0);
                    }

                    if (advAG()) {
                        Service.gI().d(advAC.indexUI);
                        if (advAV()) {
                            phong.sleep(1000L);
                            GameScr.gI().v();
                            return false;
                        }
                    }
                }

                advAC = null;
                ;
                return true;
            }
        } else {
            return this.advAX();
        }
    }

    private static int advAA(short var0) {
        for (int var1 = 0; var1 < Char.getMyChar().arrItemBag.length; ++var1) {
            if (Char.getMyChar().arrItemBag[var1] != null && Char.getMyChar().arrItemBag[var1].template.id == var0 && (Char.getMyChar().arrItemBag[var1].upgrade <= candanh || Char.getMyChar().arrItemBag[var1].upgrade <= FormDanhVong.advAM)) {
                return var1;
            }
        }

        return -1;
    }

    protected final void auto() {
        if (FormDanhVong.DEBUG_DV) ;
        // Port TGAME: chụp snapshot bộ trang bị đầu phiên tick đầu tiên, re-capture khi qua ngày
        this.prepareOriginalEquipmentSnapshot();
        // PLAN_AUTO_DV_KICH_YEN_THEO_NHOM §3: reset flag remote-ts khi roi map DV.
        // Cho phep NV dieukien==4 ra farm nhieu lan trong cung phien deu duoc keo nhom.
        if (sentGroupTsThisFarm && TileMap.mapID != FormDanhVong.advAE) {
            sentGroupTsThisFarm = false;
        }
        if (Auto.isDead()) {
            if (TileMap.isTruong(TileMap.mapID) || TileMap.isLang(TileMap.mapID)) {
                Auto.hoisinh(false);
                return;
            }

            // Port TGAME: đổi Char.chuyenmap -> Char.remap trong nhánh hồi sinh khi chết DV, tránh tự sát không quay về
            if (Char.remap) {
                Auto.hoisinh(false);
                return;
            }
        } else {
            int var1;
            Item var9;
            // Port TGAME: neu da o lang/truong roi thi clear flag fast-return tranh dung lai
            if (this.advCH && (TileMap.isLang(TileMap.mapID) || TileMap.isTruong(TileMap.mapID))) {
                this.advCH = false;
            }
            if (advBH) {
                if (FormDanhVong.advAR > 0 && advCE < FormDanhVong.advAR) {
                    if ((var9 = Char.getItem(705)) != null) {
                        Service.gI().useItem(var9.indexUI);
                        if (advAU()) {
                            ++advCE;
                            this.advAW();
                            advCD = true;
                        }

                        return;
                    }

                    if (Char.getMyChar().luong >= 5) {
                        if (!TileMap.isTruong(TileMap.mapID) && !TileMap.isLang(TileMap.mapID)) {
                            this.remap(FormDanhVong.advAC, -2, -1, -1);
                            return;
                        }

                        GameScr.pickNPC(26, 0, 0);
                        LockGame.waitDV();
                        int found705 = -1;
                        if (GameScr.bu != null) {
                            for (var1 = 0; var1 < GameScr.bu.length; ++var1) {
                                if (GameScr.bu[var1].template.id == 705) { found705 = var1; break; }
                            }
                        }
                        if (found705 >= 0) {
                            Service.gI().a(GameScr.bu[found705].typeUI, GameScr.bu[found705].indexUI, 1);
                            LockGame.advAG();
                            GameScr.gI().v();
                            return;
                        }
                        Code.popup_chat("Shop Goosho không có DV phù (id 705) — kiểm tra cấu hình pserver");
                        endauto = true;
                    }
                }

                // Port TGAME: replace 2 exit points với restore snapshot trang bị đầu phiên
                this.finalizeSessionWithRestore(false);
                return;
            }

            if ((var1 = getCalendar(indexLanguage).get(5)) != advCF) {
                advAZ = 0;
                advBA = 0;
                advCE = 0;
                advCF = var1;
            }

            if (dieukien > 0 && !hoanthanh && !endauto) {
                if (dieukien < 4) {
                    if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                        if (FormDanhVong.advAE <= 0) {
                            if (this.advCG == null) {
                                GameScr.pickNPC(25, 1, 0);
                                LockGame.advAK();
                                this.advCG = Char.get_nvhn(0);
                            }

                            if (this.advCG != null) {
                                advCD = true;
                                FormDanhVong.advAE = this.advCG.g;
                                super.isPhoban = TileMap.isPhuBan(FormDanhVong.advAE);
                            }
                        }

                        if (FormDanhVong.advAE <= 0) {
                            Code.popup_chat("Chưa đặt map hoặc k có nvhn");
                            endauto = true;
                            return;
                        }

                        if (TileMap.mapID == FormDanhVong.advAE) {
                            if (!super.isPhoban) {
                                if (FormDanhVong.advAF >= 0 && TileMap.zoneID != FormDanhVong.advAF) {
                                    // [FIX 11-A] khu cố định: so direct zoneID, không qua khu_auto
                                    this.chuyenkhu1(FormDanhVong.advAF);
                                } else if (FormDanhVong.advAF < 0
                                        && System.currentTimeMillis() - lastAutoPickKhuTime > 30000L) {
                                    lastAutoPickKhuTime = System.currentTimeMillis();
                                    this.chuyenkhu2(TileMap.zoneID);
                                    return;
                                }
                            }

                            if (danhduoc < candanh) {
                                // PLAN_AUTO_DV_KICH_YEN_THEO_NHOM §2: leader DV da dung map+khu DV
                                // -> gui group "ts <map> <khu> -1" 1 lan de keo nhom di theo ho tro
                                // up quai. KHONG goi run_ts -> Code.mode van la AutoDanhVong.
                                if (!sentGroupTsThisFarm
                                        && !super.isPhoban
                                        && Auto.isLeader()
                                        && GameScr.vParty.size() > 1
                                        && (FormDanhVong.advAF < 0 || TileMap.zoneID == FormDanhVong.advAF)) {
                                    int targetKhu = (FormDanhVong.advAF >= 0) ? FormDanhVong.advAF : TileMap.zoneID;
                                    Code.callGroupTsRemote(FormDanhVong.advAE, targetKhu, -1);
                                    sentGroupTsThisFarm = true;
                                }

                                if (FormDanhVong.advAP == 0) {
                                    this.attack(-1, dieukien == 2 ? 3 : (dieukien == 3 ? 5 : 1));
                                } else {
                                    if (!Char.santatl) {
                                        Char.santatl = true;
                                    }

                                    this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                                }

                                this.nhatdo(-1);
                                return;
                            }

                            hoanthanh = true;
                            if (this.tryFastReturnOnComplete()) {
                                return;
                            }

                            if (Char.chuyenmap) {
                                Auto.tusat_vdmq();
                                return;
                            }

                            this.remap(FormDanhVong.advAC, -2, -1, -1);
                            return;
                        }

                        if (!advCD && FormDanhVong.advAJ > 0 && (TileMap.isLang(FormDanhVong.advAJ) || TileMap.isTruong(FormDanhVong.advAJ))) {
                            if (TileMap.mapID != FormDanhVong.advAJ) {
                                this.remap(FormDanhVong.advAJ, -2, -1, -1);
                            }

                            GameScr.pickNPC(5, 1, 0);
                            if (LockGame.advAY()) {
                                advCD = true;
                                phong.sleep(1000L);
                            }
                        }

                        this.remap(FormDanhVong.advAE, FormDanhVong.advAF, -1, -1);
                        return;
                    }

                    if (this.advAY()) {
                        endauto = true;
                        advCD = true;
                        return;
                    }
                } else {
                    if (dieukien == 4) {
                        if (FormDanhVong.advAK == 1) {
                            Code.popup_chat("Dừng auto nv nâng cấp: " + itemTemplate.name);
                            endauto = true;
                            return;
                        }

                        if (FormDanhVong.advAL < candanh) {
                            dieukien = 0;
                            return;
                        }

                        if ((var1 = advAA(itemTemplate.id)) < 0) {
                            if (this.advAZ()) {
                                endauto = true;
                                advCD = true;
                                return;
                            }
                            if (dieukien == 0) return; // advAX đã hủy NV, thoát ngay
                        } else if (danhduoc < candanh) {
                            Char var2;
                            var9 = (var2 = Char.getMyChar()).arrItemBag[var1];
                            int var3 = 0;
                            int var4 = 0;
                            if (isTypeClothe(var9)) {
                                var3 = GameScr.cy[var9.upgrade];
                                var4 = GameScr.dc[var9.upgrade];
                            } else if (isTypeAdorn(var9)) {
                                var3 = GameScr.cz[var9.upgrade];
                                var4 = GameScr.dd[var9.upgrade];
                            } else if (isTypeWeapon(var9)) {
                                var3 = GameScr.da[var9.upgrade];
                                var4 = GameScr.de[var9.upgrade];
                            }

                            int var5 = GameScr.df[var9.upgrade];
                            float var6;
                            if (((var6 = (float) (countCrystalValue() * 100 / var3)) >= (float) var5 * 0.9F || Code.solg_hanhtrang() <= 2 && var6 > 0.0F) && var4 <= var2.yen) {
                                if (Char.chuyenmap && !TileMap.isLang(TileMap.mapID) && !TileMap.isTruong(TileMap.mapID)) {
                                    Auto.tusat_vdmq();
                                    phong.sleep(500L);
                                    return;
                                }

                                if (!TileMap.isLang(TileMap.mapID)) {
                                    if (FormDanhVong.advAJ > 0 && TileMap.isLang(FormDanhVong.advAJ)) {
                                        this.remap(FormDanhVong.advAJ, -2, -1, -1);
                                        return;
                                    }

                                    this.remap(22, -2, -1, -1);
                                    return;
                                }

                                GameScr.pickNPC(6, 0, 0);
                                LockGame.advAQ();
                                GameScr.ci = var9;
                                GameScr.ca = new Item[18];
                                var1 = 0;
                                var4 = 0;
                                var6 = 0.0F;

                                for (int var7 = 0; var7 < var2.arrItemBag.length; ++var7) {
                                    Item var8;
                                    if ((var8 = var2.arrItemBag[var7]) != null && var8.template.type == 26 && var8.template.id <= 4) {
                                        GameScr.indexSelect = var7;
                                        GameScr.ca[var1] = var8;
                                        var2.arrItemBag[var7] = null;
                                        if ((var6 = (float) ((var4 += GameScr.cx[var8.template.id]) * 100 / var3)) >= (float) var5 * 0.9F || var1 >= 17) {
                                            break;
                                        }

                                        ++var1;
                                    }
                                }

                                if (var6 > 0.0F) {
                                    phong.sleep(1000L);
                                    Service.gI().a(GameScr.ci, GameScr.ca, false);
                                    if (LockGame.advAQ()) {
                                        phong.sleep(1000L);
                                    }
                                }

                                GameScr.ci = null;
                                return;
                            }

                            if (GameScr.aa()) {
                                GameScr.gI().v();
                                phong.sleep(1500L);
                            }

                            if (Code.solg_hanhtrang() <= 2) {
                                endauto = true;
                                Code.popup_chat("Hành trang không đủ chỗ trống");
                                ;
                                return;
                            }

                            if (FormDanhVong.advAE <= 0) {
                                if (this.advCG == null) {
                                    GameScr.pickNPC(25, 1, 0);
                                    LockGame.advAK();
                                    this.advCG = Char.get_nvhn(0);
                                }

                                if (this.advCG != null) {
                                    advCD = true;
                                    FormDanhVong.advAE = this.advCG.g;
                                    super.isPhoban = TileMap.isPhuBan(FormDanhVong.advAE);
                                }
                            }

                            if (FormDanhVong.advAE <= 0) {
                                Code.popup_chat("Chưa đặt map hoặc k có nvhn");
                                endauto = true;
                                return;
                            }

                            if (TileMap.mapID == FormDanhVong.advAE) {
                                if (!super.isPhoban) {
                                    if (FormDanhVong.advAF >= 0 && TileMap.zoneID != FormDanhVong.advAF) {
                                        // [FIX 11-A] khu cố định: so direct zoneID
                                        this.chuyenkhu1(FormDanhVong.advAF);
                                    } else if (FormDanhVong.advAF < 0
                                            && System.currentTimeMillis() - lastAutoPickKhuTime > 30000L) {
                                        lastAutoPickKhuTime = System.currentTimeMillis();
                                        this.chuyenkhu2(TileMap.zoneID);
                                        return;
                                    }
                                }

                                // PLAN_AUTO_DV_KICH_YEN_THEO_NHOM §2: NV nang cap (dieukien==4)
                                // dang phai farm da/yen -> goi nhom di theo. Cung dieu kien
                                // nhu nhanh dieukien<4: phai dung map+khu, la leader, co nhom.
                                if (!sentGroupTsThisFarm
                                        && !super.isPhoban
                                        && Auto.isLeader()
                                        && GameScr.vParty.size() > 1
                                        && (FormDanhVong.advAF < 0 || TileMap.zoneID == FormDanhVong.advAF)) {
                                    int targetKhu = (FormDanhVong.advAF >= 0) ? FormDanhVong.advAF : TileMap.zoneID;
                                    Code.callGroupTsRemote(FormDanhVong.advAE, targetKhu, -1);
                                    sentGroupTsThisFarm = true;
                                }

                                this.nhatdo(-1);
                                if (FormDanhVong.advAP == 0) {
                                    this.attack(-1, 1);
                                    return;
                                }

                                this.attack(-1, this.a(Char.quaithuong, Char.quaitinhanh, Char.quaithulinh));
                                return;
                            }

                            if (!advCD && FormDanhVong.advAJ > 0 && (TileMap.isLang(FormDanhVong.advAJ) || TileMap.isTruong(FormDanhVong.advAJ))) {
                                if (TileMap.mapID != FormDanhVong.advAJ) {
                                    this.remap(FormDanhVong.advAJ, -2, -1, -1);
                                }

                                GameScr.pickNPC(5, 1, 0);
                                if (LockGame.advAY()) {
                                    advCD = true;
                                    phong.sleep(1000L);
                                }
                            }

                            this.remap(FormDanhVong.advAE, FormDanhVong.advAF, -1, -1);
                        }

                        return;
                    }

                    if (dieukien == 5) {
                        if (FormDanhVong.advAB == null || FormDanhVong.advAB.length() == 0) {
                            Code.popup_chat("Hãy chat ld để set thông tin");
                            endauto = true;
                            return;
                        }

                        // Port TGAME stateless leave party: nếu đang là leader của nhóm ≥2 người,
                        // gửi Service.t() rời nhóm trước khi AutoLoiWin remap vào map lôi đài,
                        // tránh server teleport thành viên nhóm theo vào map đấu.
                        if (GameScr.vParty.size() > 1
                                && ((Party) GameScr.vParty.firstElement()).d.equals(Char.getMyChar().cName)) {
                            Service.gI().t();
                            phong.sleep(300L);
                            return;
                        }

                        if (Char.getMyChar().arrItemBody[itemTemplate.type] != null && Char.getMyChar().arrItemBody[itemTemplate.type].template.id == itemTemplate.id) {
                            if (danhduoc < candanh) {
                                if (FormDanhVong.DEBUG_DV) ;
                                Code.advAG.auto();
                                return;
                            }
                        } else if (this.advAY()) {
                            endauto = true;
                            return;
                        }
                    }
                }
            } else {
                if (!TileMap.isTruong(TileMap.mapID)) {
                    // Port TGAME: lan dau vao DV ma con o map farm -> tu sat ve lang/truong
                    if (this.tryFastReturnOnStart()) {
                        return;
                    }

                    if (TileMap.mapID != 111) {
                        if (TileMap.mapID == 129 || TileMap.mapID == 149) {
                            phong.sleep(1000L);
                            Auto.tusat_vdmq();
                            return;
                        }

                        if (this.tryFastReturnOnComplete()) {
                            return;
                        }

                        this.remap(FormDanhVong.advAC, -2, -1, -1);
                    }

                    return;
                }

                if (!advCD && FormDanhVong.advAJ > 0 && (TileMap.isLang(FormDanhVong.advAJ) || TileMap.isTruong(FormDanhVong.advAJ))) {
                    GameScr.pickNPC(5, 1, 0);
                    if (LockGame.advAY()) {
                        advCD = true;
                        phong.sleep(1000L);
                    }
                }

                if (dieukien == -2) {
                    Code.popup_chat("Xem Info NVDV " + (advAZ + 1));
                    if (FormDanhVong.DEBUG_DV) ;
                    GameScr.pickNPC(2, 1, 6);
                    if (FormDanhVong.DEBUG_DV) ;
                    boolean wdv = LockGame.waitDV();
                    if (FormDanhVong.DEBUG_DV) ;
                    return;
                }

                if (dieukien == -1) {
                    Code.popup_chat("Nhận NVDV " + (advAZ + 1));
                    if (FormDanhVong.DEBUG_DV) ;
                    GameScr.pickNPC(2, 1, 0);
                    if (FormDanhVong.DEBUG_DV) ;
                    boolean wdv2 = LockGame.waitDV();
                    if (FormDanhVong.DEBUG_DV) ;
                    return;
                }

                if (dieukien == 0) {
                    ;
                    Code.popup_chat("Hủy NVDV " + (advAZ + 1));
                    GameScr.npc_h(2);
                    Service.gI().o(8);
                    LockGame.waitDV();
                    dieukien = -1;  // reset de nhan quest moi (vong sau se pickNPC 2,1,0)
                    ++advAZ;
                    return;
                }

                if (endauto || hoanthanh) {
                    if (advAC != null) {
                        if (advBE != null) {
                            ;
                            var1 = advBE.indexUI;
                            Service.gI().useItem(var1);
                            if (LockGame.advAQ()) {
                                if (Char.getMyChar().arrItemBox == null) {
                                    Service.gI().i(4);
                                    LockGame.advAS();
                                }

                                if (Code.solg_ruong() > 0) {
                                    ;
                                    GameScr.pickNPC(5, 0, 0);
                                    if (advAE()) {
                                        GameScr.pickNPC(5, 0, 0);
                                    }

                                    if (advAG()) {
                                        Service.gI().e(var1);
                                        advAA();
                                        GameScr.gI().v();
                                    }
                                }
                            }

                            advBE = null;
                        } else {
                            if (Char.getMyChar().arrItemBox == null) {
                                Service.gI().i(4);
                                LockGame.advAS();
                            }

                            if (Code.solg_ruong() > 0) {
                                ;
                                GameScr.pickNPC(5, 0, 0);
                                if (advAE()) {
                                    GameScr.pickNPC(5, 0, 0);
                                }

                                if (advAG()) {
                                    Service.gI().e(advAC.indexUI);
                                    advAA();
                                    GameScr.gI().v();
                                }
                            }
                        }

                        advAC = null;
                    } else if (advBD != null) {
                        if (advBE != null) {
                            ;
                            Service.gI().useItem(advBE.indexUI);
                            LockGame.advAQ();
                            advBE = null;
                        }

                        advBD = null;
                    }

                    if (hoanthanh) {
                        if (FormDanhVong.DEBUG_DV) ;
                        if (dieukien == 4) {
                            GameScr.gI().v();
                            phong.sleep(1500L);
                        }

                        if (Code.solg_hanhtrang() <= 0) {
                            hoanthanh = false;
                            endauto = true;
                            Code.popup_chat("Hành trang đầy");
                            return;
                        }

                        Code.popup_chat("Hoàn thành NVDV " + (advAZ + 1));
                        GameScr.pickNPC(2, 1, 1);
                        LockGame.waitDV();
                        ++advAZ;
                        ++advBA;
                        return;
                    }

                    // Port TGAME: replace exit point 2 với restore snapshot trang bị đầu phiên
                    // needSleepBefore=true để giữ phong.sleep(3000L) cũ
                    this.finalizeSessionWithRestore(true);
                    return;
                }
            }
        }

    }

    // V8 server: completion text co the o data[2]/data[3] hoac data[6+] (do them dong info phu).
    // NV nang cap: dong "- Hoan thanh..." nam ngay sau dong tien do nang cap (data[2]).
    private static boolean checkHoanThanh(String[] data) {
        for (int i = 2; i < data.length; i++) {
            if (data[i] != null && data[i].trim().equals("- Hoàn thành nhiệm vụ, hãy gặp Ameji để trả nhiệm vụ")) {
                return true;
            }
        }
        return false;
    }

    // V8 server gui "- Sử dụng trang bị ItemName." thay vi "- Sử dụng ItemName"
    // Can strip "trang bị " prefix va "." suffix
    private static String cleanItemName(String raw) {
        if (raw == null) return raw;
        String s = raw.trim();
        if (s.startsWith("trang bị ")) {
            s = s.substring(9); // bo "trang bị " (9 chars)
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1); // bo "."
        }
        return s.trim();
    }

    public final String toString() {
        String var1 = "Auto DV " + advBA + "/" + advAZ;
        if (dieukien > 0 && dieukien <= 5) {
            switch (dieukien) {
                case 1:
                    var1 = var1 + " - Đánh quái thường: ";
                    break;
                case 2:
                    var1 = var1 + " - Đánh tinh anh: ";
                    break;
                case 3:
                    var1 = var1 + " - Đánh thủ lĩnh: ";
                    break;
                case 4:
                    var1 = var1 + " - Nâng cấp: ";
                    break;
                case 5:
                    var1 = var1 + " - Lôi đài: ";
            }

            var1 = var1 + dadanh + "/" + phaidanh;
        }

        return var1;
    }

    static {
        String var0 = String.valueOf((char) 59);
        advBL = new String[]{ com.monkey.nso.Bridge.d("IBliHkQJLx47UllCLRw5"), com.monkey.nso.Bridge.d("IBlsHkQJLx47UllCLRw5") };
        advBM = Code.split_string("Đã hủy nhiệm vụ; canceled", var0);
        advBN = Code.split_string("- Có thể nhận thêm; - Can take", var0);
        advBO = Code.split_string("Tiêu diệt quái; Defeat monster", var0);
        advBP = Code.split_string("Tiêu diệt tinh anh; Defeat Elites monster", var0);
        advBQ = Code.split_string("Tiêu diệt thủ lĩnh; Defeat Chief monster", var0);
        advBR = Code.split_string("Chiến thắng lôi đài; Win battle", var0);
        sudungtb = Code.split_string("- Sử dụng; - Use", var0);
        tieudiet = Code.split_string("Tiêu diệt; Defeat", var0);
        advBU = Code.split_string("- Chiến thắng; - Win", var0);
        advBV = Code.split_string("Nâng cấp trang bị; Upgrade", var0); // V8 server: "Nâng cấp trang bị" (NSOZ: "Nâng cấp vật phẩm")
        advBW = Code.split_string("Lên cấp; To level", var0);
    }
}
