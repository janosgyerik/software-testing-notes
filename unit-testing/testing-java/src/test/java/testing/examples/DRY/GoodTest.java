package testing.examples.DRY;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // GOOD: there is no unnecessary duplication in the test cases,
    // the repeated external call to ExcelSheetUtils.titleToNumber is encapsulated
    // in a private helper method

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_throws() {
        titleToNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_invalid_throws() {
        titleToNumber("$");
    }

    @Test
    public void test_a_is_1() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_z_is_26() {
        assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test_aa_is_27() {
        assertEquals(27, titleToNumber("AA"));
    }

}
