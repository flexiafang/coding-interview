package 面试题03_数组中重复的数字_I;

/**
 * 将每个数字放到正确的位置
 *
 * @Author hustffx
 * @Date 2020/8/5
 */
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
