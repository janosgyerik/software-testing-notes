package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompareVersionNumbersTest {
    public int compareVersion(String version1, String version2) {
        String[] parts1 = version1.replaceAll("(\\.0+)+$", "").split("\\.");
        String[] parts2 = version2.replaceAll("(\\.0+)+$", "").split("\\.");
        int parts1len = parts1.length;
        int parts2len = parts2.length;
        int maxParts = Math.max(parts1len, parts2len);
        for (int i = 0; i < maxParts; ++i) {
            if (i >= parts1len) {
                return -1;
            }
            if (i >= parts2len) {
                return 1;
            }
            int item1 = Integer.parseInt(parts1[i]);
            int item2 = Integer.parseInt(parts2[i]);
            int cmp = Integer.compare(item1, item2);
            if (cmp != 0) {
                return cmp;
            }
        }
        return 0;
    }

    @Test
    public void test_0_1_vs_1_1() {
        assertEquals(-1, compareVersion("0.1", "1.1"));
    }

    @Test
    public void test_1_1_vs_0_1() {
        assertEquals(1, compareVersion("1.1", "0.1"));
    }

    @Test
    public void test_1_1_vs_1_1() {
        assertEquals(0, compareVersion("1.1", "1.1"));
    }

    @Test
    public void test_0_1_vs_1_2() {
        assertEquals(-1, compareVersion("0.1", "1.2"));
    }

    @Test
    public void test_1_1_vs_13_37() {
        assertEquals(-1, compareVersion("1.1", "13.37"));
    }

    @Test
    public void test_1_1_vs_1_1_1() {
        assertEquals(-1, compareVersion("1.1", "1.1.1"));
    }

    @Test
    public void test_1_1_1_vs_1_1() {
        assertEquals(1, compareVersion("1.1.1", "1.1"));
    }

    @Test
    public void test_1_2_1_vs_1_3() {
        assertEquals(-1, compareVersion("1.2.1", "1.3"));
    }

    @Test
    public void test_01_vs_1() {
        assertEquals(0, compareVersion("01", "1"));
    }

    @Test
    public void test_1_0_vs_1_10() {
        assertEquals(-1, compareVersion("1.0", "1.10"));
    }

    @Test
    public void test_1_2_vs_1_10() {
        assertEquals(-1, compareVersion("1.2", "1.10"));
    }

    @Test
    public void test_1_0_vs_1() {
        assertEquals(0, compareVersion("1.0", "1"));
    }

    @Test
    public void test_looooooong() {
        assertEquals(0, compareVersion(
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.00.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000",
                "19.8.3.17.5.01.0.0.4.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0000.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.0.000000"));
    }
}
