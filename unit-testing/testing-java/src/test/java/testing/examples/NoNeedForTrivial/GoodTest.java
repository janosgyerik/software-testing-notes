package testing.examples.NoNeedForTrivial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: all test cases are interesting, non-trivial

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
    public void test_bb() {
        assertEquals(26 * 2 + 2, titleToNumber("BB"));
    }

}
