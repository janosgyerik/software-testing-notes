package testing.refimpl;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class CountAndSayTest {
    public String countAndSay(int n) {
        Pattern pattern = Pattern.compile("(\\d)\\1*");
        String text = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder builder = new StringBuilder();
            Matcher matcher = pattern.matcher(text);
            int start = 0;
            while (matcher.find(start)) {
                String segment = matcher.group();
                builder.append(segment.length()).append(segment.charAt(0));
                start += segment.length();
            }
            text = builder.toString();
        }
        return text;
    }

    @Test
    public void test_first() {
        assertEquals("1", countAndSay(1));
    }

    @Test
    public void test_1() {
        assertEquals("11", countAndSay(2));
    }

    @Test
    public void test_11() {
        assertEquals("21", countAndSay(3));
    }

    @Test
    public void test_21() {
        assertEquals("1211", countAndSay(4));
    }

    @Test
    public void test_1211() {
        assertEquals("111221", countAndSay(5));
    }
    // 312211
    // 13112221
    // 1113213211
    // 31131211131221
    // 13211311123113112211
    // 11131221133112132113212221
}
