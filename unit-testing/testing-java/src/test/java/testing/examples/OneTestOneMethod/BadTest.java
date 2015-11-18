package testing.examples.OneTestOneMethod;

import org.junit.Test;
import testing.common.ExcelSheetColumnIndex;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return new ExcelSheetColumnIndex().titleToNumber(title);
    }

    @Test
    public void test_a_bunch_of_things() {
        assertEquals(1, titleToNumber("A"));
        assertEquals(26, titleToNumber("Z"));
        assertEquals(27, titleToNumber("AA"));
        assertEquals(54, titleToNumber("BB"));
    }
}
