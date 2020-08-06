package 面试题06_从尾到头打印链表;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ListNode;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class PrintListInReverseOrderTest {

    private PrintListInReverseOrder solution;
    private ListNode head;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        solution = new PrintListInReverseOrder();
        head = ListNode.addAll(1, 2, 3);
        expected = new int[]{3, 2, 1};
    }

    @Test
    public void reversePrint1() {
        Assert.assertArrayEquals(expected, solution.reversePrint1(head));
    }

    @Test
    public void reversePrint2() {
        Assert.assertArrayEquals(expected, solution.reversePrint2(head));
    }
}