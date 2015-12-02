package testing.examples.NoPrinting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: the test cases assert what they test
    //
    // When you run these tests in an IDE, you can look at the color
    // of the output to tell if the assumptions were satisfied or not:
    // everything should be green.
    // When you run these tests with "mvn test",
    // if the output says 100% success, you *know* the tests have passed,
    // no need to read, analyze, interpret printed results.

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
