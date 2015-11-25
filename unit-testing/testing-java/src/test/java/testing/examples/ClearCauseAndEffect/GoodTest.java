package testing.examples.ClearCauseAndEffect;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

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
