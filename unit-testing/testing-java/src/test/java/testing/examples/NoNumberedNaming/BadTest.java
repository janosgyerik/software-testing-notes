package testing.examples.NoNumberedNaming;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: using numbering in test method names is unacceptable.
    //
    // When a test fails, the name of the method in the failure summary
    // will not help understanding the problem.

    @Test
    public void test1() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test2() {
        assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test3() {
        assertEquals(27, titleToNumber("AA"));
    }

    @Test
    public void test4() {
        assertEquals(54, titleToNumber("BB"));
    }

}
