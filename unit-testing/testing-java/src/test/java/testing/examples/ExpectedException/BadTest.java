package testing.examples.ExpectedException;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: NOT using `expected = ` to verify that an exception will be thrown.
    // Using `fail()` for this is hacky, and verbose.

    @Test
    public void test_empty_throws() {
        try {
            titleToNumber("");
            fail();
        } catch (IllegalArgumentException e) {
            // good, as expected!
        }
    }
}
