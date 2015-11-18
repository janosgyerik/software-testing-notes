package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinaryTest {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        {
            int p1 = a.length() - 1;
            int p2 = b.length() - 1;
            int carryover = 0;

            while (p1 >= 0 || p2 >= 0) {
                int digit = carryover;
                if (p1 >= 0) {
                    digit += a.charAt(p1--) - '0';
                }
                if (p2 >= 0) {
                    digit += b.charAt(p2--) - '0';
                }
                if (digit > 1) {
                    digit %= 2;
                    carryover = 1;
                } else {
                    carryover = 0;
                }
                builder.append(digit);
            }
            if (carryover > 0) {
                builder.append(carryover);
            }
        }
        return builder.reverse().toString();
    }

    @Test
    public void test_11_1() {
        assertEquals("100", addBinary("11", "1"));
    }

    @Test
    public void test_0_0() {
        assertEquals("0", addBinary("0", "0"));
    }

    @Test
    public void test_1111_0() {
        assertEquals("1111", addBinary("1111", "0"));
    }

    @Test
    public void test_1101_1() {
        assertEquals("1110", addBinary("1101", "1"));
    }

    @Test
    public void test_1111_1111() {
        assertEquals("11110", addBinary("1111", "1111"));
    }
}
