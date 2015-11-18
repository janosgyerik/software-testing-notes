package testing.refimpl;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class PlusOneTest {
    public int[] plusOne(int[] digits) {
        int[] newDigits = digits.clone();
        int pos = digits.length - 1;
        int carryover = 1;
        while (pos >= 0) {
            int digit = carryover + newDigits[pos];
            if (digit > 9) {
                digit %= 10;
                carryover = 1;
            } else {
                carryover = 0;
            }
            newDigits[pos--] = digit;
        }
        if (carryover > 0) {
            int[] newDigitsOverflowed = new int[digits.length + 1];
            System.arraycopy(newDigits, 0, newDigitsOverflowed, 1, digits.length);
            newDigitsOverflowed[0] = 1;
            return newDigitsOverflowed;
        }
        return newDigits;
    }

    @Test
    public void test_1_9() {
        assertEquals("[2, 0]", Arrays.toString(plusOne(new int[]{1, 9})));
    }

    @Test
    public void test_9_9() {
        assertEquals("[1, 0, 0]", Arrays.toString(plusOne(new int[]{9, 9})));
    }

}
