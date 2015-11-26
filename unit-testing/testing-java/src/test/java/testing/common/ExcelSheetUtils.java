package testing.common;

public class ExcelSheetUtils {

    private ExcelSheetUtils() {
        throw new AssertionError("utility class, forbidden constructor");
    }

    /**
     * Convert an Excel sheet column title to numeric index.
     *
     * Examples:
     *
     * "A" -> 1
     * "Z" -> 26
     * "AA" -> 27
     * "ZZ" -> 702
     * "ABCD" -> 19010
     *
     * @param title The title to convert
     * @return The numeric index corresponding to the title
     */
    public static int titleToNumber(String title) {
        if (!title.matches("[A-Z]+")) {
            throw new IllegalArgumentException("Invalid title: should be capital letters");
        }
        int number = 0;
        int len = title.length();
        for (int pos = 0; pos < len; ++pos) {
            if (number > Integer.MAX_VALUE / 26) {
                throw new IllegalArgumentException("Invalid title: too large, integer overflow detected");
            }
            number *= 26;
            number += title.charAt(pos) - 'A' + 1;
        }
        return number;
    }
}
