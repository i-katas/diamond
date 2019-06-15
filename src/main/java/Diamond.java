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
        int head = TOP_LEVEL_CHAR;
        while (head <= letter - 1) {
            out.append(print((char) (head)));
            head++;
        }
        out.append(print(letter));
        int tail = letter - 1;
        while (tail >= TOP_LEVEL_CHAR) {
            out.append(print((char) tail));
            tail--;
        }
        return out.toString();
    }

    private CharSequence print(char current) {
        return current == TOP_LEVEL_CHAR ? String.valueOf(current) : new String(new char[]{current, current});
    }
}
