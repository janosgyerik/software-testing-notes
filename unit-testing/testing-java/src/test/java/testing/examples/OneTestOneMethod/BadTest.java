package testing.examples.OneTestOneMethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: one method should test only one thing
    //
    // When a test fails, the failure summary
    // will not help understanding the problem.

    @Test
    public void test_a_bunch_of_things() {
        try {
            titleToNumber("");
            fail();
        } catch (IllegalArgumentException e) {
            // good, as expected!
        }

        assertEquals(1, titleToNumber("A"));
        assertEquals(26, titleToNumber("Z"));
        assertEquals(27, titleToNumber("AA"));
        assertEquals(54, titleToNumber("BB"));

        for (int j = 'A'; j < 'Z'; ++j) {
            assertEquals(1 + 'A' - 'A' + (1 + j - 'A') * 26, titleToNumber("" + (char) j + 'A'));
        }
        for (int j = 'A'; j < 'Z'; ++j) {
            assertEquals(1 + 'B' - 'A' + (1 + j - 'A') * 26, titleToNumber("" + (char) j + 'B'));
        }
        for (int j = 'A'; j < 'Z'; ++j) {
            assertEquals(1 + 'C' - 'A' + (1 + j - 'A') * 26, titleToNumber("" + (char) j + 'C'));
        }
    }
}
