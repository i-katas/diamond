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
        return print(this.letter).toString();
    }

    private StringBuilder print(char current) {
        StringBuilder out = new StringBuilder();
        out.append(current);
        if (current != TOP_LEVEL_CHAR) {
            out.append(current);
        }
        return out;
    }
}
