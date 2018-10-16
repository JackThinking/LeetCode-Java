package medium._494;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, 1, S - nums[0]);
        helper(nums, 1, S + nums[0]);
        return count;
    }

    private void helper(int[] nums, int index, int target) {
        if (index == nums.length) {
            /*
            * 这种target的题目，往往是找target-nums[]的值，而不是sum起来找
            * */
            if (target == 0) {
                count++;
            }
            return;
        }
        helper(nums, index + 1, target - nums[index]);
        helper(nums, index + 1, target + nums[index]);
    }
}
