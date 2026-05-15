package javax.microedition.rms;

/**
 * J2ME RecordStore stub for LibGDX.
 * TGAME's RMS.java has been replaced with file-based storage,
 * but some List* classes still import this. Provides no-op stubs.
 */
public class RecordStore {
    private String name;
    private byte[] record;
    private int numRecords = 0;

    private RecordStore(String name) {
        this.name = name;
    }

    public static RecordStore openRecordStore(String name, boolean createIfNecessary) throws Exception {
        return new RecordStore(name);
    }

    public static void deleteRecordStore(String name) throws Exception {
    }

    public int getNumRecords() {
        return numRecords;
    }

    public byte[] getRecord(int recordId) throws Exception {
        return record;
    }

    public int addRecord(byte[] data, int offset, int length) throws Exception {
        record = new byte[length];
        System.arraycopy(data, offset, record, 0, length);
        numRecords = 1;
        return 1;
    }

    public void setRecord(int recordId, byte[] data, int offset, int length) throws Exception {
        record = new byte[length];
        System.arraycopy(data, offset, record, 0, length);
    }

    public void closeRecordStore() throws Exception {
    }
}
