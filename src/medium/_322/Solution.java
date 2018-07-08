package medium._322;


/**
 * Created by Citrix on 2018/7/8.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;//因为要取不到才行
            for (int coin:coins){
                if (coin<=i && dp[i-coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }

        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[amount];
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,5};
        System.out.println(solution.coinChange(nums,11));
    }
}
