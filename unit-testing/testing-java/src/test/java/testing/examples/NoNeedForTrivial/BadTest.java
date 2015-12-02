package testing.examples.NoNeedForTrivial;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: trivial test cases are noise; a waste of time to read (and write).
    //
    // Just like with regular code, the less code the better.
    // The more code you have, the higher risk of mistakes.
    // Avoid pointless tests, as much as avoiding pointless code.

    @Test
    public void test_a() {
        assertTrue(titleToNumber("A") > 0);
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_b() {
        assertTrue(titleToNumber("B") > 0);
        assertEquals(2, titleToNumber("B"));
    }

    @Test
    public void test_c() {
        assertTrue(titleToNumber("C") > 0);
        assertEquals(3, titleToNumber("C"));
    }
}
