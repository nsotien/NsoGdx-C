package javax.microedition.lcdui;

public class ChoiceGroup {
    public static final int EXCLUSIVE = 1;
    public static final int MULTIPLE = 2;
    public static final int POPUP = 4;

    private String label;
    private int type;
    private String[] elements;
    private boolean[] selected;
    private int count = 0;

    public ChoiceGroup(String label, int choiceType) {
        this.label = label;
        this.type = choiceType;
        this.elements = new String[20];
        this.selected = new boolean[20];
    }

    public ChoiceGroup(String label, int choiceType, String[] elements, Object[] images) {
        this.label = label;
        this.type = choiceType;
        this.elements = elements != null ? elements : new String[20];
        this.selected = new boolean[this.elements.length];
        this.count = elements != null ? elements.length : 0;
    }

    public int append(String element, Object image) {
        if (count < elements.length) {
            elements[count] = element;
            return count++;
        }
        return -1;
    }

    public String getString(int index) { return elements[index]; }
    public int getSelectedIndex() {
        for (int i = 0; i < count; i++) {
            if (selected[i]) return i;
        }
        return -1;
    }
    public boolean isSelected(int index) { return selected[index]; }
    public void setSelectedIndex(int index, boolean sel) { selected[index] = sel; }
    public int size() { return count; }
    public void deleteAll() { count = 0; }
}
