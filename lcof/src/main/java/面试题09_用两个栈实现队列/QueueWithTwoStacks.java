package 面试题09_用两个栈实现队列;

import java.util.Stack;

/**
 * @Author hustffx
 * @Date 2020/8/12
 */
public class QueueWithTwoStacks {

    // stack1中的元素一定比stack2中的元素后放入队列
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public QueueWithTwoStacks() {
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}
