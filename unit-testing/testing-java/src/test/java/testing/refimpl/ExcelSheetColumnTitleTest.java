package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnTitleTest {
    public String numberToTitle(int num) {
        StringBuilder builder = new StringBuilder();
        do {
            char c = (char) ('A' + ((num - 1) % 26));
            builder.append(c);
            if (num % 26 == 0) {
                --num;
            }
            num /= 26;
        } while (num > 0);
        return builder.reverse().toString();
    }

    @Test
    public void test_a() {
        assertEquals("A", numberToTitle(1));
    }

    @Test
    public void test_z() {
        assertEquals("Z", numberToTitle(26));
    }

    @Test
    public void test_zz() {
        assertEquals("ZZ", numberToTitle(702));
    }

    @Test
    public void test_aa() {
        assertEquals("AA", numberToTitle(27));
    }

    @Test
    public void test_ab() {
        assertEquals("AB", numberToTitle(28));
    }

    @Test
    public void test_abcd() {
        assertEquals("ABCD", numberToTitle(19010));
    }

}
