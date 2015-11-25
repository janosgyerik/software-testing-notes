package testing.examples.ValidateInput;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // GOOD: test cases validate input and interesting corner cases

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_throws() {
        titleToNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_invalid_throws() {
        titleToNumber("$");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_partly_invalid_throws() {
        titleToNumber("A$");
    }

    @Test
    public void test_a() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_z() {
        assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test_aa() {
        assertEquals(26 + 1, titleToNumber("AA"));
    }

    @Test
    public void test_az() {
        assertEquals(26 + 26, titleToNumber("AZ"));
    }

    @Test
    public void test_ba() {
        assertEquals(26 + 26 + 1, titleToNumber("BA"));
    }

    @Test
    public void test_bz() {
        assertEquals(26 + 26 + 26, titleToNumber("BZ"));
    }

    @Test
    public void test_ca() {
        assertEquals(26 + 26 + 26 + 1, titleToNumber("CA"));
    }

    @Test
    public void test_zzzzzz() {
        assertEquals(321272406, titleToNumber("ZZZZZZ"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_zzzzzzz_overflows() {
        titleToNumber("ZZZZZZZ");
    }
}
