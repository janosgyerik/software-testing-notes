package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthOfLastWordTest {
    public int lengthOfLastWord(String s) {
        String sanitized = s.replaceAll("\\W+", " ").trim();
        int lastSpace = sanitized.lastIndexOf(' ');
        return sanitized.length() - (lastSpace < 0 ? 0 : lastSpace + 1);
    }

    @Test
    public void testEmpty() {
        assertEquals(0, lengthOfLastWord(""));
    }

    @Test
    public void testSingleWord() {
        assertEquals(5, lengthOfLastWord("hello"));
    }

    @Test
    public void testTrailingSpace() {
        assertEquals(5, lengthOfLastWord("hello    "));
    }

    @Test
    public void test_hi_world() {
        assertEquals(5, lengthOfLastWord("hi world"));
    }

    @Test
    public void test_today_is_a_nice_day() {
        assertEquals(3, lengthOfLastWord("Today is a nice day"));
    }

}
