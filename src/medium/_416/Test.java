package medium._416;

import java.util.Arrays;

/**
 * Created by Citrix on 2019-04-26.
 */
public class Test {
    int[][] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                memo[i][j] = -1;
            }
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    /*
     * 在数组nums里面找到path和为sum的一组值
     * */
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index < 0 || sum < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        if (tryPartition(nums, index - 1, sum - nums[index]) || tryPartition(nums, index - 1, sum)) {
            memo[index][sum] = 1;
        } else {
            memo[index][sum] = 0;
        }
        return memo[index][sum] == 1;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int C = sum / 2;
        boolean[] dp = new boolean[C + 1];
        for (int i = 0; i <= C; i++) {
            dp[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[C];
    }


    public static void main(String[] args) {
        Test t = new Test();
        int[] test = {1, 1};
        System.out.println(t.canPartition2(test));
    }
}
