package testing.refimpl;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergeSortedArrayTet {
    public void merge(int A[], int m, int B[], int n) {
        System.arraycopy(A, 0, A, n, m);
        int p1 = n;
        int p2 = 0;
        int front = 0;
        while (p1 < A.length && p2 < n) {
            if (A[p1] <= B[p2]) {
                A[front] = A[p1++];
            } else {
                A[front] = B[p2++];
            }
            ++front;
        }
        while (p1 < A.length) {
            A[front++] = A[p1++];
        }
        while (p2 < n) {
            A[front++] = B[p2++];
        }
    }

    @Test
    public void test_first_empty() {
        int[] first = new int[2];
        merge(first, 0, new int[]{1, 2}, 2);
        assertEquals("[1, 2]", Arrays.toString(first));
    }

    @Test
    public void test_second_empty() {
        int[] first = new int[]{1, 2};
        merge(first, 2, new int[0], 0);
        assertEquals("[1, 2]", Arrays.toString(first));
    }

    @Test
    public void test_both_empty() {
        int[] first = new int[0];
        merge(first, 0, new int[0], 0);
        assertEquals("[]", Arrays.toString(first));
    }

    @Test
    public void test_interweaved_first_first() {
        int[] first = new int[]{1, 3, 5, 0, 0, 0};
        merge(first, 3, new int[]{2, 4, 6}, 3);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(first));
    }

    @Test
    public void test_interweaved_second_first() {
        int[] first = new int[]{2, 4, 6, 0, 0, 0};
        merge(first, 3, new int[]{1, 3, 5}, 3);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(first));
    }

    @Test
    public void test_concat_first_then_second() {
        int[] first = new int[]{1, 2, 3, 0, 0, 0};
        merge(first, 3, new int[]{4, 5, 6}, 3);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(first));
    }

    @Test
    public void test_concat_second_then_first() {
        int[] first = new int[]{4, 5, 6, 0, 0, 0};
        merge(first, 3, new int[]{1, 2, 3}, 3);
        assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(first));
    }
}
