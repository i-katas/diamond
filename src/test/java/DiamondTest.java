import org.junit.Ignore;
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
    @Ignore
    public void twoLayeredDiamond() {
        //@formatter:off
        assertThat(Diamond.of('B').print(), equalTo(
            " A\n"+
            "B B\n"+
            " A"
        ));
        //@formatter:on
    }

    @Test
    public void repeatInnerLayerCharacter() {
        assertThat(stripAll(Diamond.of('A')), equalTo("A"));
        assertThat(stripAll(Diamond.of('B')), containsString("BB"));
        assertThat(stripAll(Diamond.of('C')), containsString("CC"));
    }

    @Test
    public void repeatCurrentLevelLineExceptMiddleLevel() {
        assertThat(stripAll(Diamond.of('B')), equalTo("ABBA"));
        assertThat(stripAll(Diamond.of('C')), equalTo("ABBCCBBA"));
    }

    private String stripAll(Diamond diamond) {
        return stripAll(diamond.print(), "\\s+");
    }

    private String stripAll(String s, String regex) {
        return s.replaceAll(regex, "");
    }
}
