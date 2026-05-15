package javax.microedition.lcdui;

public class TextField {
    public static final int ANY = 0;
    public static final int EMAILADDR = 1;
    public static final int NUMERIC = 2;
    public static final int PHONENUMBER = 3;
    public static final int URL = 4;
    public static final int PASSWORD = 0x10000;

    private String label;
    private String text;
    private int maxSize;
    private int constraints;

    public TextField(String label, String text, int maxSize, int constraints) {
        this.label = label;
        this.text = text;
        this.maxSize = maxSize;
        this.constraints = constraints;
    }

    public String getString() { return text; }
    public void setString(String text) { this.text = text; }
    public String getLabel() { return label; }
    public int getMaxSize() { return maxSize; }
    public int size() { return text != null ? text.length() : 0; }
}
