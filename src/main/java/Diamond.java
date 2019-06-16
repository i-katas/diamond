import java.util.Arrays;

/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class Diamond {
    private static final char TOP_LEVEL_CHAR = 'A';
    private static final char LF = '\n';
    private static final char SPACE = ' ';
    private static final String NONE = "";
    private final char middle;

    public Diamond(char middle) {
        this.middle = middle;
    }

    public static Diamond of(char letter) {
        return new Diamond(letter);
    }

    public String print() {
        return String.valueOf(top()) + line(middle) + bottom();
    }

    private CharSequence top() {
        StringBuilder it = new StringBuilder();
        for (char start = TOP_LEVEL_CHAR, end = (char) (middle - 1); start <= end; start++) {
            it.append(line(start)).append(LF);
        }
        return it;
    }

    private CharSequence bottom() {
        StringBuilder it = new StringBuilder();
        for (char start = TOP_LEVEL_CHAR, end = (char) (middle - 1); start <= end; end--) {
            it.append(LF).append(line(end));
        }
        return it;
    }

    private CharSequence line(char current) {
        return indent(current) + current + (current == TOP_LEVEL_CHAR ? NONE : spaces(current) + current);
    }

    private String indent(char current) {
        return repeat(SPACE, middle - current);
    }

    private String spaces(char current) {
        return repeat(SPACE, width(current) - 2);
    }

    private int width(char current) {
        return 2 * (current - TOP_LEVEL_CHAR) + 1;
    }

    private String repeat(char c, int n) {
        if (n == 0) {
            return NONE;
        }
        if (n == 1) {
            return String.valueOf(c);
        }
        char[] chars = new char[n];
        Arrays.fill(chars, c);
        return String.valueOf(chars);
    }
}
