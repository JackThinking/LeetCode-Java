package medium._213;

/**
 * Created by Citrix on 2018/8/17.
 */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        if (len < 2){
            return nums[0];
        }
        int dp1 = 0,dp2 = 0,dp3 = 0,dp4 = 0;
        for (int i = 2; i < len; i++) {
            int tmp1 = Math.max(dp1,dp2+nums[i]);
            int tmp2 = Math.max(dp3,dp4+nums[i]);
            dp2 = dp1;
            dp1 = tmp1;
            dp4 = dp3;
            dp3 = tmp2;
        }
        return Math.max(dp1,dp3);
    }
}
