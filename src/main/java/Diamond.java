import java.util.Arrays;

/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class Diamond {
    private static final char TOP_LEVEL_CHAR = 'A';
    private static final char LF = '\n';
    private static final char SPACE = ' ';
    private char letter;

    public Diamond(char letter) {
        this.letter = letter;
    }

    public static Diamond of(char letter) {
        return new Diamond(letter);
    }

    public String print() {
        return String.valueOf(top(letter)) + print(letter, letter) + bottom(letter);
    }

    private StringBuilder top(final char letter) {
        StringBuilder it = new StringBuilder();
        for (int start = TOP_LEVEL_CHAR, end = letter - 1; start <= end; start++) {
            it.append(print((char) (start), letter)).append(LF);
        }
        return it;
    }

    private StringBuilder bottom(final char letter) {
        StringBuilder it = new StringBuilder();
        for (int start = TOP_LEVEL_CHAR, end = letter - 1; start <= end; end--) {
            it.append(LF).append(print((char) end, letter));
        }
        return it;
    }

    private CharSequence print(char current, char middle) {
        if (current == TOP_LEVEL_CHAR) {
            return indent(current, middle) + current;
        }
        return String.valueOf(current) + spaces(current) + current;
    }

    private String indent(char current, char middle) {
        return repeat(SPACE, middle - current);
    }

    private CharSequence spaces(char current) {
        return repeat(SPACE, width(current) - 2);
    }

    private int width(char current) {
        return 2 * (current - TOP_LEVEL_CHAR) + 1;
    }

    private String repeat(char c, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, c);
        return String.valueOf(chars);
    }
}
