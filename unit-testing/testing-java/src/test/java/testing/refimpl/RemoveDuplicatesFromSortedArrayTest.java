package testing.refimpl;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveDuplicatesFromSortedArrayTest {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if (len < 1) {
            return len;
        }
        int front = 1;
        int prev = A[0];
        for (int i = 1; i < len; ++i) {
            int current = A[i];
            if (current != prev) {
                A[front++] = current;
                prev = current;
            }
        }
        return front;
    }

    private void assertStartsWith(int[] expected, int[] arr) {
        assertTrue(expected.length <= arr.length);
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], arr[i]);
        }
    }

    @Test
    public void test_1_1_2() {
        int[] arr = {1, 1, 2};
        int newSize = removeDuplicates(arr);
        assertEquals(2, newSize);
        assertEquals("[1, 2, 2]", Arrays.toString(arr));
        assertStartsWith(new int[]{1, 2}, arr);
    }

    @Test
    public void test_0() {
        int[] arr = {};
        int newSize = removeDuplicates(arr);
        assertEquals(0, newSize);
        assertEquals("[]", Arrays.toString(arr));
    }

    @Test
    public void test_1() {
        int[] arr = {1};
        int newSize = removeDuplicates(arr);
        assertEquals(1, newSize);
        assertEquals("[1]", Arrays.toString(arr));
    }

    @Test
    public void test_1_1() {
        int[] arr = {1, 1};
        int newSize = removeDuplicates(arr);
        assertEquals(1, newSize);
        assertEquals("[1, 1]", Arrays.toString(arr));
    }

    @Test
    public void test_1_1_1() {
        int[] arr = {1, 1, 1};
        int newSize = removeDuplicates(arr);
        assertEquals(1, newSize);
        assertEquals("[1, 1, 1]", Arrays.toString(arr));
    }

    @Test
    public void test_1_1_1_2() {
        int[] arr = {1, 1, 1, 2};
        int newSize = removeDuplicates(arr);
        assertEquals(2, newSize);
        assertEquals("[1, 2, 1, 2]", Arrays.toString(arr));
    }

    @Test
    public void test_1_1_2_2_3_3() {
        int[] arr = {1, 1, 2, 2, 3, 3};
        int newSize = removeDuplicates(arr);
        assertEquals(3, newSize);
        assertEquals("[1, 2, 3, 2, 3, 3]", Arrays.toString(arr));
    }
}
