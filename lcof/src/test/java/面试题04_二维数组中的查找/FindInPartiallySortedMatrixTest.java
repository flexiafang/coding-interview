package 面试题04_二维数组中的查找;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class FindInPartiallySortedMatrixTest {

    private FindInPartiallySortedMatrix solution;
    private int[][] matrix;
    private int target;
    private boolean expected;

    @Before
    public void setUp() throws Exception {
        solution = new FindInPartiallySortedMatrix();
        matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        target = 5;
        expected = true;
    }

    @Test
    public void findNumberInMatrix() {
        Assert.assertEquals(expected, solution.findNumberInMatrix(matrix, target));
    }
}