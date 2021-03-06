package testing.examples.OneTestOneMethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: the different cases are correctly separated

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_throws() {
        titleToNumber("");
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
