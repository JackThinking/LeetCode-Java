package medium._416;

/**
 * Created by Citrix on 2018/10/22.
 */
public class test {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum / 2;
        /*
         * index属性忘了
         * */
        return helper(nums.length - 1, nums, sum);
    }

    private boolean helper(int index, int[] nums, int remain) {
        /*
        * index作为截止条件
        * */
        if (index == -1) {
            return false;
        }
        if (remain == nums[index]) {
            return true;
        }
        if (remain < nums[index]) {
            return false;
        }
        return helper(index - 1, nums, remain - nums[index]) || helper(index - 1, nums, remain);
    }
}
