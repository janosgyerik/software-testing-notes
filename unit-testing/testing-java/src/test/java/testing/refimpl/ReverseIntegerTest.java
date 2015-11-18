package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTest {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int work = Math.abs(x);
        long result = 0;
        while (work > 0) {
            result *= 10;
            int digit = work % 10;
            result += digit;
            work /= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return sign * (int) result;
    }

    @Test
    public void test_0() {
        assertEquals(0, reverse(0));
    }

    @Test
    public void test_1() {
        assertEquals(1, reverse(1));
    }

    @Test
    public void test_minus_1() {
        assertEquals(-1, reverse(-1));
    }

    @Test
    public void test_123() {
        assertEquals(321, reverse(123));
    }

    @Test
    public void test_minus_123() {
        assertEquals(-321, reverse(-123));
    }

    @Test
    public void test_1534236469() {
        assertEquals(0, reverse(1534236469));
    }

    @Test
    public void test_100() {
        assertEquals(1, reverse(100));
    }

}
