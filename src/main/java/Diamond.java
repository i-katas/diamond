/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class Diamond {
    private char letter;

    public Diamond(char letter) {
        this.letter = letter;
    }

    public static Diamond of(char letter) {
        return new Diamond(letter);
    }

    public String print() {
        return String.valueOf(letter);
    }
}
