package testing.examples.CornerCases;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: interesting corner cases are covered

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
    public void test_A_gives_1() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_Z_gives_26() {
        assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test_AA_gives_27() {
        assertEquals(26 + 1, titleToNumber("AA"));
    }

    @Test
    public void test_AZ_gives_52() {
        assertEquals(26 + 26, titleToNumber("AZ"));
    }

    @Test
    public void test_BA_gives_53() {
        assertEquals(26 + 26 + 1, titleToNumber("BA"));
    }

    @Test
    public void test_BZ_gives_78() {
        assertEquals(26 + 26 + 26, titleToNumber("BZ"));
    }

    @Test
    public void test_CA_gives_79() {
        assertEquals(26 + 26 + 26 + 1, titleToNumber("CA"));
    }

    @Test
    public void test_ZZZZZZ() {
        assertEquals(321272406, titleToNumber("ZZZZZZ"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_ZZZZZZZ_overflows() {
        titleToNumber("ZZZZZZZ");
    }
}
