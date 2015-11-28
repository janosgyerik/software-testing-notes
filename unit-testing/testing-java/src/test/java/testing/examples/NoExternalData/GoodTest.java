package testing.examples.NoExternalData;

import org.junit.Test;
import testing.common.ExcelSheetUtils;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class GoodTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // GOOD: test data is loaded from the class path
    //
    // However, as much as possible, it's best to keep test data
    // in the test class itself, so that cause and effect are easily visible

    private static final String TEST_DATA_SHEET_CSV =
            GoodTest.class.getPackage().getName().replaceAll("\\.", "/") + "/data.csv";

    private Scanner getTestDataScanner() {
        return new Scanner(this.getClass().getClassLoader().getResourceAsStream(TEST_DATA_SHEET_CSV));
    }

    @Test
    public void test_examples_in_file() {
        Scanner scanner = getTestDataScanner();
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            int expected = Integer.parseInt(parts[0]);
            int actual = titleToNumber(parts[1]);
            assertEquals(expected, actual);
        }
    }
}
