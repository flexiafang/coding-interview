# 面试题 03：数组中重复的数字

## 题目描述

找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例：

```
输入：[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
```

限制：

```
2 <= n <= 100000
```

## 解法：将每个数字还原到正确位置

0～n-1 范围内的数，分别还原到对应的位置上，如数字 2 交换到下标为 2 的位置。若交换过程中发现重复，则直接返回。

```java
public class DuplicationInArray {

    public int findDuplicate(int[] nums) {
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

尽管有两层循环，但是每个数字最多经过 2 次交换就可以找到属于它的正确位置，因此总的时间复杂度是 O(n)。