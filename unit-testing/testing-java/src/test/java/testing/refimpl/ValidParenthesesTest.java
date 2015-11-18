package testing.refimpl;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
    public boolean isValid(String s) {
        char[] arr = "hello".toCharArray();
        Arrays.sort(arr);
        Stack<Character> nextExpectedClosing = new Stack<>();
        int len = s.length();
        for (int pos = 0; pos < len; ++pos) {
            char c = s.charAt(pos);
            switch (c) {
                case '(':
                    nextExpectedClosing.push(')');
                    break;
                case '{':
                    nextExpectedClosing.push('}');
                    break;
                case '[':
                    nextExpectedClosing.push(']');
                    break;
                default:
                    if (nextExpectedClosing.empty() || c != nextExpectedClosing.pop()) {
                        return false;
                    }
            }
        }
        return nextExpectedClosing.empty();
    }

    @Test
    public void test_empty() {
        assertTrue(isValid(""));
    }

    @Test
    public void test_aa() {
        assertTrue(isValid("()"));
    }

    @Test
    public void test_aabbcc() {
        assertTrue(isValid("()[]{}"));
    }

    @Test
    public void test_ab() {
        assertFalse(isValid("(]"));
    }

    @Test
    public void test_abab() {
        assertFalse(isValid("([)]"));
    }

    @Test
    public void test_b() {
        assertFalse(isValid("]"));
    }
}
