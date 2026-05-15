package javax.microedition.lcdui;

public class List extends Displayable {
    public static final int IMPLICIT = 3;
    public static final int EXCLUSIVE = 1;
    public static final int MULTIPLE = 2;

    private String title;
    private int type;
    private String[] elements = new String[50];
    private int count = 0;

    public List(String title, int listType) {
        this.title = title;
        this.type = listType;
    }

    public List(String title, int listType, String[] elements, Object[] images) {
        this.title = title;
        this.type = listType;
        if (elements != null) {
            for (String e : elements) append(e, null);
        }
    }

    public int append(String element, Object image) {
        if (count < elements.length) {
            elements[count] = element;
            return count++;
        }
        return -1;
    }

    public void delete(int index) {
        if (index >= 0 && index < count) {
            System.arraycopy(elements, index + 1, elements, index, count - index - 1);
            count--;
        }
    }

    public void deleteAll() { count = 0; }
    public String getString(int index) { return elements[index]; }
    public int getSelectedIndex() { return 0; }
    public void setSelectedIndex(int index, boolean sel) {}
    public int size() { return count; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
