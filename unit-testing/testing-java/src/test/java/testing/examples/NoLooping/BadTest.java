package testing.examples.NoLooping;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: test cases should not have complicated code, such as loops.
    //
    // Paranoia should have its limits. There's no need to check the
    // full range of possible inputs. Cover the corner cases,
    // and pick some interesting cases.

    @Test
    public void test_a_to_z() {
        for (int i = 'A'; i < 'Z'; ++i) {
            assertEquals(1 + i - 'A', titleToNumber("" + (char) i));
        }
    }
}
