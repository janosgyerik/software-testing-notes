package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTest {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        String longest = strs[0];
        for (int i = 1; i < len && !longest.isEmpty(); ++i) {
            longest = findCommonPrefix(longest, strs[i]);
        }
        return longest;
    }

    private String findCommonPrefix(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int pos = 0;
        while (pos < len1 && pos < len2) {
            if (s1.charAt(pos) != s2.charAt(pos)) {
                break;
            }
            ++pos;
        }
        return s1.substring(0, pos);
    }

    @Test
    public void test_empty() {
        assertEquals("", longestCommonPrefix(new String[0]));
    }

    @Test
    public void test_no_common() {
        assertEquals("", longestCommonPrefix(new String[]{"a", "bb"}));
    }

    @Test
    public void test_a_a() {
        assertEquals("a", longestCommonPrefix(new String[]{"a", "a"}));
    }

    @Test
    public void test_single() {
        assertEquals("single", longestCommonPrefix(new String[]{"single"}));
    }

    @Test
    public void test_a_aa() {
        assertEquals("a", longestCommonPrefix(new String[]{"a", "aa"}));
    }

    @Test
    public void test_abs_abdomen() {
        assertEquals("ab", longestCommonPrefix(new String[]{"abs", "abdomen"}));
    }
}
