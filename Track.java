import java.util.Iterator;

class Track implements Iterator {
    private String string;
    private int cursor;

    Track(String string) {
        this.string = string;
    }

    @Override
    public boolean hasNext() {
        return cursor < string.length();
    }

    @Override
    public Integer next() {
        char c = string.charAt(cursor);
        if (c == ' ')
            c = string.charAt(++cursor);
        cursor++;
        if (c == '0') {
            return -1;
        } else if (c == '-' || c == '+') {
            int value = c == '-' ? -1 : 13;
            c = string.charAt(cursor++);
            return Integer.valueOf(String.valueOf(c)) + value;
        } else {
            return Integer.valueOf(String.valueOf(c)) + 6;
        }
    }
}
