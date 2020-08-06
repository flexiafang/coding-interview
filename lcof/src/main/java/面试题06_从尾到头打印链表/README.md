# [面试题06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

## 题目描述

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例：**

```
输入：head = [1,3,2]
输出：[2,3,1]
```

**限制：**

```
0 <= 链表长度 <= 10000
```

## 解法 1 栈

```java
public class PrintListInReverseOrder {
    
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
}
```

## 解法 2 递归

```java
public class PrintListInReverseOrder {
    
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
```

