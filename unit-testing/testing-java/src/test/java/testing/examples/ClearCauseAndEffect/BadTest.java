package testing.examples.ClearCauseAndEffect;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: the logic between the inputs and expected outputs is NOT clear.
    // Why is the index of AA 27?
    // Why is the index of BB 54?

    @Test
    public void test_aa() {
        assertEquals(27, titleToNumber("AA"));
    }

    @Test
    public void test_bb() {
        assertEquals(54, titleToNumber("BB"));
    }

}
