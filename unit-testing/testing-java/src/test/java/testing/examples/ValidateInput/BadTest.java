package testing.examples.ValidateInput;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

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
