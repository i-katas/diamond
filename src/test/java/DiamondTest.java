import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author xiaoliang
 * @since 2019-06-15
 */
public class DiamondTest {
    @Test
    public void singleLayeredDiamond() {
        assertThat(Diamond.of('A').print(), equalTo("A"));
    }

    @Test
    public void multipleLayeredDiamond() {
        //@formatter:off
        assertThat(Diamond.of('C').print(), equalTo(
            "  A\n"+
            " B B\n"+
            "C   C\n"+
            " B B\n"+
            "  A"
        ));
        //@formatter:on
    }

    @Test
    public void repeatsCharacterForAllInnerLines() {
        assertThat(stripAll(Diamond.of('A')), equalTo("A"));
        assertThat(stripAll(Diamond.of('B')), containsString("BB"));
        assertThat(stripAll(Diamond.of('C')), containsString("CC"));
    }

    @Test
    public void repeatsLinesExceptTheMiddleLine() {
        assertThat(stripAll(Diamond.of('B')), equalTo("ABBA"));
        assertThat(stripAll(Diamond.of('C')), equalTo("ABBCCBBA"));
    }

    @Test
    public void diamondTotalLines() {
        assertThat(totalLinesOf(Diamond.of('A')), equalTo(1));
        assertThat(totalLinesOf(Diamond.of('B')), equalTo(3));
        assertThat(totalLinesOf(Diamond.of('C')), equalTo(5));
    }

    @Test
    public void printsSpacesForAllInnerLines() {
        assertThat(Diamond.of('B').print(), containsString("B B"));
        assertThat(Diamond.of('C').print(), containsString("B B"));
        assertThat(Diamond.of('C').print(), containsString("C   C"));
    }

    @Test
    public void printIndentsForAllLinesExceptTheMiddleLine() {
        assertThat(stripAllLF(Diamond.of('B')), equalTo(" AB B A"));
        assertThat(stripAllLF(Diamond.of('C')), equalTo("  A B BC   C B B  A"));
    }


    private int totalLinesOf(Diamond diamond) {
        return diamond.print().split("\n").length;
    }

    private String stripAllLF(Diamond diamond) {
        return stripAll(diamond, "\\n");
    }

    private String stripAll(Diamond diamond) {
        return stripAll(diamond, "\\s+");
    }

    private String stripAll(Diamond diamond, String regex) {
        return diamond.print().replaceAll(regex, "");
    }
}
