package testing.refimpl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RemoveElementTest {
    public int removeElement(int[] A, int elem) {
        int back = A.length - 1;
        int pos = 0;
        while (pos <= back) {
            if (A[back] == elem) {
                --back;
                continue;
            }
            if (A[pos] == elem) {
                A[pos] = A[back--];
            }
            ++pos;
        }
        return pos;
    }

    void validate(int[] arr, int len, int item) {
        for (int i = 0; i < len; ++i) {
            assertNotEquals(item, arr[i]);
        }
    }

    @Test
    public void test_nothing_removed() {
        int[] arr = new int[]{1, 2, 3, 4};
        int item = 9;
        int result = removeElement(arr, item);
        assertEquals(arr.length, result);
        validate(arr, result, item);
    }

    @Test
    public void test_all_removed() {
        int[] arr = new int[]{1, 1, 1, 1};
        int item = 1;
        int result = removeElement(arr, item);
        assertEquals(0, result);
        validate(arr, result, item);
    }

    @Test
    public void test_1_2_1_1_remove_1() {
        int[] arr = new int[]{1, 2, 1, 1};
        int item = 1;
        int result = removeElement(arr, item);
        assertEquals(1, result);
        validate(arr, result, item);
    }

    @Test
    public void test_1_2_1_1_remove_2() {
        int[] arr = new int[]{1, 2, 1, 1};
        int item = 2;
        int result = removeElement(arr, item);
        assertEquals(3, result);
        validate(arr, result, item);
    }
}
