package 面试题03_数组中重复的数字_II;

/**
 * @Author hustffx
 * @Date 2020/8/6
 */
public class DuplicationInArray {

    /**
     * 解法1：二分查找
     */
    public int findDuplicate1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }

        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 统计小于等于 mid 的数字的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                // 重复元素在区间 [left, mid]
                right = mid;
            } else {
                // 重复元素在区间 [mid + 1, right]
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 解法2：快慢指针（循环检测）
     */
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
