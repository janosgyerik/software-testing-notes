package testing.examples.NoLocalData;

import org.junit.Ignore;
import org.junit.Test;
import testing.common.ExcelSheetUtils;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BadTest {

    private int titleToNumber(String title) {
        return ExcelSheetUtils.titleToNumber(title);
    }

    // BAD: test cases should use data from the local filesystem.
    // Test cases that depend on local data are effectively broken.
    // If you want to read data from files, put them in src/test/resources

    private static final String TEST_DATA_SHEET_CSV = "c:/tmp/test-data-sheet.csv";

    @Ignore
    @Test
    public void test_examples_in_file() {
        Scanner scanner = new Scanner(TEST_DATA_SHEET_CSV);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            int expected = Integer.parseInt(parts[0]);
            int actual = titleToNumber(parts[1]);
            assertEquals(expected, actual);
        }
    }
}
