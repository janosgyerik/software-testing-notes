package testing.examples.Simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: not simple enough. At all. Test cases should be simple, easy to read.
    //
    // The magic numbers are hard to read.
    // The loop logic is hard to read.
    //
    // In general, there shouldn't be non-trivial logic in tests, and no loops.
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
