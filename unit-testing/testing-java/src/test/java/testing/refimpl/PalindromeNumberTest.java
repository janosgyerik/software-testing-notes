package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeNumberTest {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = Math.abs(x);
        int digits = (int) Math.log10(num);
        int firstDivisor = (int) Math.pow(10, digits);
        int lastDivisor = 1;
        while (firstDivisor > lastDivisor) {
            int firstDigit = num / firstDivisor % 10;
            int lastDigit = num / lastDivisor % 10;
            if (firstDigit != lastDigit) {
                return false;
            }
            firstDivisor /= 10;
            lastDivisor *= 10;
        }
        return true;
    }

    @Test
    public void test_1() {
        assertTrue(isPalindrome(1));
    }

    @Test
    public void test_12() {
        assertFalse(isPalindrome(12));
    }

    @Test
    public void test_121() {
        assertTrue(isPalindrome(121));
    }

    @Test
    public void test_1221() {
        assertTrue(isPalindrome(1221));
    }

    @Test
    public void test_1213121() {
        assertTrue(isPalindrome(1213121));
    }

//    @Test
    public void test_m11() {
        assertTrue(isPalindrome(-11));
    }

    @Test
    public void test_111119() {
        assertFalse(isPalindrome(111119));
    }

    @Test
    public void test_min() {
        assertFalse(isPalindrome(Integer.MIN_VALUE));
    }

    @Test
    public void test_m2147447412() {
        assertFalse(isPalindrome(-2147447412));
    }
}
