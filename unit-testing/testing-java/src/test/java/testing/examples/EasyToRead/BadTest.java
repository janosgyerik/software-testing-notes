package testing.examples.EasyToRead;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: not easy to read or understand. Test cases should be simple, easy to read.
    //
    // In general, there shouldn't be logic in tests.
    // Test cases should contain simple, straightforward assertions.

    @Test
    public void test_a_to_z() {
        for (int i = 'A'; i < 'Z'; ++i) {
            assertEquals(1 + i - 'A', titleToNumber("" + (char) i));
        }
    }
}
