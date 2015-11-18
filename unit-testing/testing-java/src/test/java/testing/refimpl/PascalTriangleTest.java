package testing.refimpl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalTriangleTest {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }

        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        
        List<Integer> previousRow = Arrays.asList(1, 1);
        result.add(previousRow);
        for (int i = 3; i <= numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < i - 2; ++j) {
                row.add(previousRow.get(j) + previousRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
            previousRow = row;
        }
        return result;
    }

    @Test
    public void test_1() {
        assertEquals(Arrays.asList(Arrays.asList(1)), generate(1));
    }

    @Test
    public void test_2() {
        assertEquals(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1)
        ), generate(2));
    }

    @Test
    public void test_5() {
        assertEquals(Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 2, 1),
                Arrays.asList(1, 3, 3, 1),
                Arrays.asList(1, 4, 6, 4, 1)
        ), generate(5));
    }
}
