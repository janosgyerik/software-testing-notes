package testing.examples.NoNumberedNaming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnIndex_GoodTest {

    private int titleToNumber(String title) {
        return new ExcelSheetColumnIndex().titleToNumber(title);
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
        assertEquals(27, titleToNumber("AA"));
    }

    @Test
    public void test_bb() {
        assertEquals(54, titleToNumber("BB"));
    }

}
