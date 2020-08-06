# [面试题03. 数组中重复的数字](https://leetcode-cn.com/problems/find-the-duplicate-number/)

## 题目描述

在一个长度为 n+1 的数组 nums 里的所有数字都在 1～n 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字，但不能修改数组。

示例：

```
输入：[2, 3, 5, 4, 3, 2, 6, 7]
输出：2 或 3 
```

限制：

```
2 <= n <= 100000
```

## 解法 1 二分查找

先猜一个数（有效范围 [left, right] 里的中间数 mid），然后统计原始数组中**小于等于**这个中间数的元素的个数 count，如果 count **严格大于** mid，根据抽屉原理，重复元素就在区间 [left, mid] 里。

```java
public class DuplicationInArray {

    public int findDuplicateNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            // 判断下标i与数值nums[i]是否相等
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 将nums[i]放到正确的位置
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
```

## 解法 2 快慢指针（循环检测）

对 nums[] 数组建图，每个位置 i 连一条 i → nums[i] 的边。由于存在的重复的数字 target，因此 target 这个位置一定有起码两条指向它的边，因此整张图一定存在环，要找的 target 就是这个环的入口。

```java
public class DuplicationInArray {
    
    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
```