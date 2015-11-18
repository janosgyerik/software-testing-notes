package testing.examples.NoLooping;

import org.junit.Test;
import testing.common.ExcelSheetColumnIndex;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return new ExcelSheetColumnIndex().titleToNumber(title);
    }

    @Test
    public void test_a_to_z() {
        for (int i = 'A'; i < 'Z'; ++i) {
            assertEquals(1 + i - 'A', titleToNumber("" + (char) i));
        }
    }
}
