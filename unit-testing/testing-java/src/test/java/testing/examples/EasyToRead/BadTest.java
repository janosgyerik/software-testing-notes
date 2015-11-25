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
    public void test_titleToNumber() {
        for (int i = 65; i < 90; ++i) {
            assertEquals(1 + i - 65, titleToNumber("" + (char) i));
            assertEquals(26 + 1 + i - 65, titleToNumber("A" + (char) i));
            assertEquals(19006 + 1 + i - 65, titleToNumber("ABC" + (char) i));
        }
    }
}
