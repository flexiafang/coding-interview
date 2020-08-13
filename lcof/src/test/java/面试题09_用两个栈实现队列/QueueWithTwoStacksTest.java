package 面试题09_用两个栈实现队列;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author hustffx
 * @Date 2020/8/13
 */
public class QueueWithTwoStacksTest {

    @Test
    public void test() {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.appendTail(3);
        assertEquals(queue.deleteHead(), 3);
        assertEquals(queue.deleteHead(), -1);
    }
}