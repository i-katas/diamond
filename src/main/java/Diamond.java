/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class Diamond {
    private static final char TOP_LEVEL_CHAR = 'A';
    private static final char LF = '\n';
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
            it.append(print((char) (start))).append(LF);
        }
        return it;
    }

    private StringBuilder bottom(char letter) {
        StringBuilder it = new StringBuilder();
        for (int start = TOP_LEVEL_CHAR, end = letter - 1; start <= end; end--) {
            it.append(LF).append(print((char) end));
        }
        return it;
    }

    private CharSequence print(char current) {
        if (current == TOP_LEVEL_CHAR) {
            return String.valueOf(current);
        }
        return String.valueOf(current) + spaces(current) + current;
    }

    private CharSequence spaces(char current) {
        int width = 2 * (current - TOP_LEVEL_CHAR) + 1;
        int n = width - 2;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(' ');
        }
        return out.toString();
    }
}
