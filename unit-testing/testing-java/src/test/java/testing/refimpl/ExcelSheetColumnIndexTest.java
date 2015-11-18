package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExcelSheetColumnIndexTest {
    public int titleToNumber(String s) {
        int number = 0;
        int len = s.length();
        for (int pos = 0; pos < len; ++pos) {
            number *= 26;
            number += s.charAt(pos) - 'A' + 1;
        }
        return number;
    }

    @Test
    public void test_a() {
        assertEquals(1, titleToNumber("A"));
    }

    @Test
    public void test_z() {
        assertEquals(26, titleToNumber("Z"));
    }

    @Test
    public void test_aa() {
        assertEquals(27, titleToNumber("AA"));
    }

    @Test
    public void test_ab() {
        assertEquals(28, titleToNumber("AB"));
    }

    @Test
    public void test_abcd() {
        assertEquals(19010, titleToNumber("ABCD"));
    }

    @Test
    public void test_zz() {
        assertEquals(702, titleToNumber("ZZ"));
    }

}
