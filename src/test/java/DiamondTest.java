import org.junit.Ignore;
import org.junit.Test;

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
}
