package testing.refimpl;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberTest {
    public boolean isHappy(int n) {
        int num = n;
        Set<Integer> seen = new HashSet<Integer>();

        while (num != 1) {
            if (seen.contains(num)) {
                return false;
            }
            seen.add(num);
            num = sumOfSquaredDigits(num);
        }
        return true;
    }

    private int sumOfSquaredDigits(int n) {
        int num = n;
        int sum = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sum += lastDigit * lastDigit;
            num /= 10;
        }
        return sum;
    }
}
