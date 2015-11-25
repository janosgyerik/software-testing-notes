package testing.examples.CornerCases;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: interesting corner cases are NOT covered

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
