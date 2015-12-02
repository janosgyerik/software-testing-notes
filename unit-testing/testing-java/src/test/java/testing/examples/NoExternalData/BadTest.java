package testing.examples.NoExternalData;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static testing.common.ExcelSheetUtils.titleToNumber;

public class BadTest {

    // BAD: test cases should NOT use data from external sources
    //
    // Test cases that depend on external sources are effectively broken.
    // If you want to read data from files, put them in src/test/resources,
    // inside project, under version control, together with the test.
    //
    // If you want to test with external data, those tests become integration tests.
    // It's best to separate integration tests from unit tests, move them
    // to a different maven module, to avoid slowing down the unit tests,
    // and to avoid temporary build failures when the external sources
    // are temporarily unavailable.

    private Scanner getTestDataScanner() {
        throw new UnsupportedOperationException("Loading data from external database...");
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
