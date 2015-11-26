package testing.examples.DRY;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    // BAD: the call to the external ExcelSheetUtils.titleToNumber method is repeated.
    //
    // If the class name or method name changes, all test cases must change too.
    // Sure, your IDE will help refactoring in your own project,
    // but if the change is in an external dependency, your IDE won't help.
    // A utility class in your project might get moved out to a utility library.
    // All these potential issues can be prevented by using a private helper method.

    @Test(expected = IllegalArgumentException.class)
    public void test_empty_throws() {
        ExcelSheetUtils.titleToNumber("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_invalid_throws() {
        ExcelSheetUtils.titleToNumber("$");
    }

    @Test
    public void test_a_is_1() {
        assertEquals(1, ExcelSheetUtils.titleToNumber("A"));
    }

    @Test
    public void test_z_is_26() {
        assertEquals(26, ExcelSheetUtils.titleToNumber("Z"));
    }

    @Test
    public void test_aa_is_27() {
        assertEquals(27, ExcelSheetUtils.titleToNumber("AA"));
    }

}
