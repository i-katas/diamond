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
        return new StringBuilder().append(print(letter - 1)).append(print(letter)).append(print(letter - 1)).toString();
    }

    private CharSequence print(int current) {
        if (current < TOP_LEVEL_CHAR) {
            return "";
        }
        StringBuilder out = new StringBuilder();
        out.append((char) current);
        if (current != TOP_LEVEL_CHAR) {
            out.append((char) current);
        }
        return out;
    }
}
