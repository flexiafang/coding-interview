package 面试题06_从尾到头打印链表;

import util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class PrintListInReverseOrder {

    /**
     * 解法1：栈
     */
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int index = 0;

        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }

        return res;
    }

    /**
     * 解法2：递归
     */
    public int[] reversePrint2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        reverseList(head, list);

        int[] res = new int[list.size()];
        int index = 0;

        for (Integer num : list) {
            res[index++] = num;
        }

        return res;
    }

    private void reverseList(ListNode head, ArrayList<Integer> list) {
        if (head == null) {
            return;
        }

        reverseList(head.next, list);
        list.add(head.val);
    }
}
