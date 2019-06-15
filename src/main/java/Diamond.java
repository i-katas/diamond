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
        if (letter - 1 >= TOP_LEVEL_CHAR) {
            out.append(print((char) (letter - 1)));
        }
        out.append(print(letter));
        if (letter - 1 >= TOP_LEVEL_CHAR) {
            out.append(print((char) (letter - 1)));
        }
        return out.toString();
    }

    private CharSequence print(char current) {
        return current == TOP_LEVEL_CHAR ? String.valueOf(current) : new String(new char[]{current, current});
    }
}
