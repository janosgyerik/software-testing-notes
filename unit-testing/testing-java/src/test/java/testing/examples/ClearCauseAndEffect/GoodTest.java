package testing.examples.ClearCauseAndEffect;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class GoodTest {

    // GOOD: the logic between the inputs and expected outputs is clear

    @Test
    public void test_aa() {
        assertEquals(26 + 1, titleToNumber("AA"));
    }

    @Test
    public void test_bb() {
        assertEquals(2 * 26 + 2, titleToNumber("BB"));
    }

}
