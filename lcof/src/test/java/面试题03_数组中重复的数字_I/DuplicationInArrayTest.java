package 面试题03_数组中重复的数字_I;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author hustffx
 * @Date 2020/8/5
 */
public class DuplicationInArrayTest {

    private DuplicationInArray solution;
    private int[] nums;
    private int expected;

    @Before
    public void setUp() {
        solution = new DuplicationInArray();
        nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        expected = 2;
    }

    @Test
    public void findDuplicateNumber1() {
        int result = solution.findDuplicate(nums);
        Assert.assertEquals(expected, result);
    }
}