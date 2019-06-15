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
        out.append(letter);
        if (letter != TOP_LEVEL_CHAR) {
            out.append(letter);
        }
        return out.toString();
    }
}
