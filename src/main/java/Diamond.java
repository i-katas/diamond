/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class Diamond {
    private static final char TOP_LEVEL_CHAR = 'A';
    private char letter;

    public Diamond(char letter) {
        this.letter = letter;
    }

    public static Diamond of(char letter) {
        return new Diamond(letter);
    }

    public String print() {
        return String.valueOf(top(letter)) + print(letter) + bottom(letter);
    }

    private StringBuilder top(char letter) {
        StringBuilder it = new StringBuilder();
        for (int start = TOP_LEVEL_CHAR, end = letter - 1; start <= end; start++) {
            it.append(print((char) (start)));
        }
        return it;
    }

    private StringBuilder bottom(char letter) {
        StringBuilder it = new StringBuilder();
        for (int start = TOP_LEVEL_CHAR, end = letter - 1; start <= end; end--) {
            it.append(print((char) end));
        }
        return it;
    }

    private CharSequence print(char current) {
        return current == TOP_LEVEL_CHAR ? String.valueOf(current) : new String(new char[]{current, current});
    }
}
