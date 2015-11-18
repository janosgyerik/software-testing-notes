package testing.common;

public class ExcelSheetUtils {
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
    public int titleToNumber(String title) {
        int number = 0;
        int len = title.length();
        for (int pos = 0; pos < len; ++pos) {
            number *= 26;
            number += title.charAt(pos) - 'A' + 1;
        }
        return number;
    }
}
