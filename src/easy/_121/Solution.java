package easy._121;

/**
 * Created by Citrix on 2018/8/30.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int maxprofit = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxprofit = Math.max(maxprofit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return maxprofit;
    }
}
