package testing.examples.Fast;

import org.junit.Ignore;
import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: test cases should be fast
    //
    // Paranoia should have its limits. There's no need to check the
    // full range of possible inputs. Cover the corner cases,
    // and pick some interesting cases.

    @Ignore
    @Test
    public void test_a_to_z() {
        for (int z = 0; z < 1000000; ++z) {
            for (int i = 'A'; i < 'Z'; ++i) {
                for (int j = 'A'; j < 'Z'; ++j) {
                    assertEquals(1 + i - 'A' + (1 + j - 'A') * 26, titleToNumber("" + (char) j + (char) i));
                }
            }
        }
    }
}
