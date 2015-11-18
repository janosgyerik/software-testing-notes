package testing.refimpl;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MajorityElementTest {
    public int majorityElement(int[] num) {
        int len = num.length;
        if (len < 2) {
            return num[0];
        }
        int half = len / 2;
        Map<Integer, Integer> counts = new HashMap<>();
        for (int item : num) {
            Integer itemCount = counts.get(item);
            if (itemCount == null) {
                itemCount = 1;
            } else if (itemCount + 1 > half) {
                return item;
            } else {
                ++itemCount;
            }
            counts.put(item, itemCount);
        }
        return 0;
    }

    @Test
    public void test_1() {
        assertEquals(1, majorityElement(new int[]{1}));
    }

    @Test
    public void test_1_1_2() {
        assertEquals(1, majorityElement(new int[]{1, 1, 2}));
    }

    @Test
    public void test_1_2_2() {
        assertEquals(2, majorityElement(new int[]{1, 2, 2}));
    }

    @Test
    public void test_1_3_2_3() {
        assertEquals(3, majorityElement(new int[]{1, 3, 2, 3, 3}));
    }
}
