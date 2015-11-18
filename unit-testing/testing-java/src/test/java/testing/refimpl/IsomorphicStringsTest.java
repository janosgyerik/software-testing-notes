package testing.refimpl;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IsomorphicStringsTest {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> used = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            Character ms = mapping.get(cs);
            if (ms == null) {
                if (used.contains(ct)) {
                    return false;
                }
                used.add(ct);
                mapping.put(cs, ct);
            } else {
                if (!ms.equals(ct)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test_egg_add_true() {
        assertEquals(true, isIsomorphic("egg", "add"));
    }

    @Test
    public void test_paper_title_true() {
        assertEquals(true, isIsomorphic("paper", "title"));
    }

    @Test
    public void test_ab_aa_false() {
        assertEquals(false, isIsomorphic("ab", "aa"));
    }

    @Test
    public void test_foo_bar_false() {
        assertEquals(false, isIsomorphic("foo", "bar"));
    }
}
