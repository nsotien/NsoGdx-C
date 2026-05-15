package javax.microedition.lcdui;

public class Alert extends Displayable {
    private String title;
    private String text;

    public Alert(String title) {
        this.title = title;
    }

    public Alert(String title, String text, Object image, Object type) {
        this.title = title;
        this.text = text;
    }

    public String getString() { return text; }
    public void setString(String text) { this.text = text; }
    public String getTitle() { return title; }
}
