package medium._416;

/**
 * Created by Citrix on 2018/10/20.
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        /*int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j - nums[i - 1]] || dp[j];
                }

            }
        }
        return dp[target];
    }*/
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return helper(nums.length - 1, nums, target);
    }
    /*
    * 为什么改成sum的情况下，时间超了，但是结果是对的，一方面sum的话还要多一个target，另外一方面发散的更厉害，不能及时停止
    * */
    private boolean helper(int index, int[] nums, int remain) {
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
