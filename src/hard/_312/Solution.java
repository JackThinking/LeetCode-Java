package hard._312;

/**
 * Created by Citrix on 2018/7/16.
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];
        return maxCoins(nums, 0,n-1,dp);
    }
    private int maxCoins(int[] nums, int start, int end, Integer[][] dp) {
        int res = 0;
        int n = nums.length;
        /*
        * 设置两边的边界条件
        * */
        int left = start == 0 ? 1 : nums[start-1];
        int right = end == n-1 ? 1 : nums[end+1];
        /*
        * 最底层的返回，结束条件
        * */
        if (start>end){
            return 0;
        }
        /*
        * 备忘录
        * */
        if (dp[start][end] != null){
            return dp[start][end];
        }
        /*
        * 核心的状态转移方程
        * */
        for (int i = start; i <= end; i++) {
            res = Math.max(res,left*nums[i]*right+maxCoins(nums,start,i-1,dp)+maxCoins(nums,i+1,end,dp));
        }
        dp[start][end] = res;
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,5,8};
        System.out.println(solution.maxCoins(nums));
    }

}
