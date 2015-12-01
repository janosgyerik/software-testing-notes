package testing.examples.NoLocalData;

import org.junit.Ignore;
import org.junit.Test;
import testing.common.ExcelSheetUtils;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: test cases should NOT use data from the local filesystem.
    //
    // Test cases that depend on local data are effectively broken.
    // If you want to read data from files, put them in src/test/resources,
    // inside project, under version control, together with the test.

    private static final String TEST_DATA_SHEET_CSV = "c:/tmp/data.csv";

    private Scanner getTestDataScanner() {
        return new Scanner(this.getClass().getClassLoader().getResourceAsStream(TEST_DATA_SHEET_CSV));
    }

    @Ignore
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
