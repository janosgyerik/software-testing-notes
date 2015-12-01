package testing.examples.OneTestOneMethod;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: one method should test only one thing
    //
    // When a test fails, the failure summary
    // will not help understanding the problem.

    @Test
    public void test_a_bunch_of_things() {
        assertEquals(1, titleToNumber("A"));
        assertEquals(26, titleToNumber("Z"));
        assertEquals(27, titleToNumber("AA"));
        assertEquals(54, titleToNumber("BB"));
    }
}
