package testing.examples.ExpectedException;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: using `expected = ` to verify that an exception will be thrown,
    // and simply making a call that will trigger the exception,
    // no need to store the result in a local variable

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_throws() {
        titleToNumber("");
    }
}
