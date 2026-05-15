package javax.microedition.lcdui;

public class TextBox extends Displayable {
    private String title;
    private String text;
    private int maxSize;
    private int constraints;

    public TextBox(String title, String text, int maxSize, int constraints) {
        this.title = title;
        this.text = text;
        this.maxSize = maxSize;
        this.constraints = constraints;
    }

    public String getString() { return text; }
    public void setString(String text) { this.text = text; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getMaxSize() { return maxSize; }
    public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
    public int getConstraints() { return constraints; }
    public void setConstraints(int constraints) { this.constraints = constraints; }
    public int size() { return text != null ? text.length() : 0; }
}
