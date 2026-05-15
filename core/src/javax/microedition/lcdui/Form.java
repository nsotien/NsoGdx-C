package javax.microedition.lcdui;

/**
 * J2ME Form stub for LibGDX.
 * Used by Setting, SettingGKN, MenuHangDong, List* classes.
 */
public class Form extends Displayable {
    private String title;

    public Form(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int append(Object item) {
        return 0;
    }

    public void delete(int index) {
    }

    public void deleteAll() {
    }

    public int size() {
        return 0;
    }

    public Object get(int index) {
        return null;
    }

    public void insert(int index, Object item) {
    }
}
