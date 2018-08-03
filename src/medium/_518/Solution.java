package medium._518;

/**
 * Created by Citrix on 2018/8/3.
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin:coins){
           for (int i = coin; i <= amount; i++) {
               dp[i] += dp[i-coin];
            }

        }
        if (dp[amount] == 0){
            return 0;
        }
        else{
            return dp[amount];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,5};
        System.out.println(solution.change(5,nums));
    }
}
