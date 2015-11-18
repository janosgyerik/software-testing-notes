package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrStrTest {
    public int strStr(String haystack, String needle) {
        int needleLen = needle.length();
        if (needleLen == 0) {
            return 0;
        }
        int hayLen = haystack.length();
        if (hayLen < needleLen) {
            return -1;
        }
        for (int hayPos = 0, needlePos = 0; hayPos < hayLen; ++hayPos) {
            if (haystack.charAt(hayPos) == needle.charAt(needlePos)) {
                ++needlePos;
                if (needlePos == needleLen) {
                    return hayPos - needleLen + 1;
                }
            } else {
                hayPos -= needlePos;
                needlePos = 0;
            }
        }
        return -1;
    }

    @Test
    public void test_hello_hi() {
        assertEquals(-1, strStr("hello", "hi"));
    }

    @Test
    public void test_hellothere_the() {
        assertEquals(6, strStr("hello there", "the"));
    }

    @Test
    public void test_there_there() {
        assertEquals(0, strStr("there", "there"));
    }

    @Test
    public void test_thethere_there() {
        assertEquals(3, strStr("thethere", "there"));
    }

    @Test
    public void test_a_empty() {
        assertEquals(0, strStr("a", ""));
    }

    @Test
    public void test_empty_empty() {
        assertEquals(0, strStr("", ""));
    }
}
