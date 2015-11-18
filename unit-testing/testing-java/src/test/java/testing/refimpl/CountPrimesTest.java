package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountPrimesTest {
    public int countPrimes(int n) {
        boolean[] nonPrimes = new boolean[n];
        int p = 2;
        int count = 0;

        while (p < n) {
            ++count;
            markNonPrimes(nonPrimes, p);
            p = nextPrime(nonPrimes, p);
        }

        return count;
    }

    private int nextPrime(boolean[] nonPrimes, int p) {
        for (int i = p + 1; i < nonPrimes.length; ++i) {
            if (!nonPrimes[i]) {
                return i;
            }
        }
        return nonPrimes.length;
    }

    private void markNonPrimes(boolean[] nonPrimes, int p) {
        for (int i = p + p; i < nonPrimes.length; i += p) {
            nonPrimes[i] = true;
        }
    }

    @Test
    public void test_3() {
        assertEquals(1, countPrimes(3));
    }

    @Test
    public void test_4() {
        assertEquals(2, countPrimes(4));
    }

    @Test
    public void test_5() {
        assertEquals(2, countPrimes(5));
    }

    @Test
    public void test_6() {
        assertEquals(3, countPrimes(6));
    }

    @Test
    public void test_16() {
        assertEquals(6, countPrimes(16));
    }
}
