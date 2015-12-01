package testing.examples.DescriptiveNaming;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: the test cases are poorly named.
    // They don't help understanding what is being tested.
    //
    // When a test fails, the name of the method in the failure summary
    // will not help understanding the problem.

    @Test(expected = IllegalArgumentException.class)
    public void test_error() {
        titleToNumber("$");
    }

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

}
