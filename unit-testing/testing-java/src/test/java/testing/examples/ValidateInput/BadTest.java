package testing.examples.ValidateInput;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: no test cases to validate input

    @Test
    public void test_a() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_c() {
        assertEquals(3, titleToNumber("C"));
    }

    @Test
    public void test_z() {
        assertEquals(26, titleToNumber("Z"));
    }
}
