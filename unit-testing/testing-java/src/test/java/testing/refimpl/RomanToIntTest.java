package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntTest {
    public int romanToInt(String s) {
        String upper = s.toUpperCase();
        int len = s.length();
        int num = 0;
        int prev = 0;
        for (int i = 0; i < len; ++i) {
            int value = 0;
            switch (upper.charAt(i)) {
                case 'I':
                    value = 1;
                    break;
                case 'V':
                    value = prev == 1 ? 3 : 5;
                    break;
                case 'X':
                    value = prev == 1 ? 8 : 10;
                    break;
                case 'L':
                    value = prev == 10 ? 30 : 50;
                    break;
                case 'C':
                    value = prev == 10 ? 80 : 100;
                    break;
                case 'D':
                    value = prev == 100 ? 300 : 500;
                    break;
                case 'M':
                    value = prev == 100 ? 800 : 1000;
                    break;
            }
            num += value;
            prev = value;
        }
        return num;
    }

    @Test
    public void test_i() {
        assertEquals(1, romanToInt("i"));
    }

    @Test
    public void test_ii() {
        assertEquals(2, romanToInt("ii"));
    }

    @Test
    public void test_iv() {
        assertEquals(4, romanToInt("iv"));
    }

    @Test
    public void test_ix() {
        assertEquals(9, romanToInt("ix"));
    }
}
