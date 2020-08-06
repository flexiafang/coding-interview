package 面试题03_数组中重复的数字_II;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class DuplicationInArrayTest {

    private DuplicationInArray solution;
    private int[] nums;
    private int expected;

    @Before
    public void setUp() {
        solution = new DuplicationInArray();
        nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
    }

    @Test
    public void findDuplicate1() {
        Assert.assertEquals(3, solution.findDuplicate1(nums));
    }

    @Test
    public void findDuplicate2() {
        Assert.assertEquals(2, solution.findDuplicate2(nums));
    }
}