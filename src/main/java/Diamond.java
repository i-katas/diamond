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
        StringBuilder out = new StringBuilder();
        char letter = this.letter;
        for (int head = TOP_LEVEL_CHAR; head <= letter - 1; head++) {
            out.append(print((char) (head)));
        }
        out.append(print(letter));
        for (int tail = letter - 1; TOP_LEVEL_CHAR <= tail; tail--) {
            out.append(print((char) tail));
        }
        return out.toString();
    }

    private CharSequence print(char current) {
        return current == TOP_LEVEL_CHAR ? String.valueOf(current) : new String(new char[]{current, current});
    }
}
