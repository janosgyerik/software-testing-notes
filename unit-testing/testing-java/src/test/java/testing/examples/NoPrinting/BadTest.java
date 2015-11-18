package testing.examples.NoPrinting;

import org.junit.Ignore;
import org.junit.Test;
import testing.common.ExcelSheetUtils;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: printing is not testing, period
    //
    // Although the inputs and the expected outputs are perfectly clear,
    // you have to read the output to verify.
    // This is NOT practical, and NOT automation.
    // Use assertions to test.
    //
    // Printing is NOT OK even if there are assertions too.
    // Printing sets a bad precedent that others might follow.
    // Don't print in tests.

    @Ignore
    @Test
    public void test_a() {
        System.out.printf("Converting A, should be 1: %s\n", titleToNumber("A"));
    }

    @Ignore
    @Test
    public void test_z() {
        System.out.printf("Converting Z, should be 26: %s\n", titleToNumber("Z"));
    }

    @Ignore
    @Test
    public void test_aa() {
        System.out.printf("Converting AA, should be 27: %s\n", titleToNumber("AA"));
    }

    @Ignore
    @Test
    public void test_bb() {
        System.out.printf("Converting BB, should be 54: %s\n", titleToNumber("BB"));
    }
}
