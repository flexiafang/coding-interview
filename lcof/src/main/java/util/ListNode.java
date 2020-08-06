package util;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /*
     * 下面是辅助测试的代码
     */

    public static ListNode addAll(int... nums) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            cur.next = node;
            cur = node;
        }
        return head.next;
    }
}
