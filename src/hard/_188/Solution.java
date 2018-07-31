package hard._188;

/**
 * Created by Citrix on 2018/7/22.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n<2){
            return 0;
        }

        if (k >= n/2){
            int maxtemp = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i]>prices[i-1]){
                    maxtemp += prices[i]-prices[i-1];
                }
            }
            return maxtemp;
        }
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localmax = dp[i-1][0]-prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1],prices[j]+localmax);
                localmax = Math.max(localmax,dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,6,5,0,3};
        System.out.println(solution.maxProfit(2,nums));
    }
}
