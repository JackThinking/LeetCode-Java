package hard._123;


/**
 * Created by Citrix on 2018/7/30.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n<1){
            return 0;
        }
        int dp[] = new int[n];
        dp[0] = 0;
        int buy = prices[0];
        int max = 0;
        for (int i = 1; i < n; i++) {//第一次循环，记录单次收益最大值
            buy = Math.min(buy,prices[i-1]);
            int sell = prices[i];
            max = Math.max(max,sell-buy);
            dp[i] = max;
        }
        max = 0;//清空max，再来一次右边到左边的循环
        int totalmax = 0;
        int sell = prices[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            buy = prices[i];
            sell = Math.max(sell, prices[i + 1]);
            max = Math.max(max, sell - buy);
            int remain = 0;//之前的dp数组，代表左边的数据
            if (i > 1) {
                remain = dp[i - 1];
            }
            totalmax = Math.max(totalmax, remain + max);
        }
        return totalmax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(nums));
    }
}
