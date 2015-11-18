package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringToIntegerTest {
    int atoi(String str) {
        int len = str.length();

        int i = 0;
        while (i < len && str.charAt(i) == ' ') {
            ++i;
        }

        int sign = 1;
        if (i < len) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                    ++i;
                    break;
                case '-':
                    sign = -1;
                    ++i;
                    break;
            }
        }

        long num = 0;
        for (; i < len; ++i) {
            char c = str.charAt(i);
            if (!('0' <= c && c <= '9')) {
                break;
            }
            num *= 10;
            num += c - '0';

            if (num >= Integer.MAX_VALUE) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                }
                if (num == Integer.MAX_VALUE) {
                    return (int) -num;
                }
                return Integer.MIN_VALUE;
            }
        }

        return (int) num * sign;
    }

    @Test
    public void test_x() {
        assertEquals(0, atoi("x"));
    }

    @Test
    public void test_minus() {
        assertEquals(0, atoi("y"));
    }

    @Test
    public void test_minus_minus() {
        assertEquals(0, atoi("--"));
    }

    @Test
    public void test_plus_x() {
        assertEquals(0, atoi("+x"));
    }

    @Test
    public void test_123() {
        assertEquals(123, atoi("123"));
    }

    @Test
    public void test_plus_123() {
        assertEquals(123, atoi("+123"));
    }

    @Test
    public void test_minus_123() {
        assertEquals(-123, atoi("-123"));
    }

    @Test
    public void test_empty() {
        assertEquals(0, atoi("0"));
    }

    @Test
    public void test_123_with_leading_spaces() {
        assertEquals(123, atoi("   123"));
    }

    @Test
    public void test_123_with_trailing_garbage() {
        assertEquals(123, atoi("123xyz"));
    }

    @Test
    public void test_plus_minus_2() {
        assertEquals(0, atoi("+-2"));
    }

    @Test
    public void test_2147483648() {
        assertEquals(2147483647, atoi("2147483648"));
    }

    @Test
    public void test_minus_2147483647() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        assertEquals(-2147483647, atoi("-2147483647"));
    }
}
