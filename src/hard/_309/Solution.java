package hard._309;


/**
 * Created by Citrix on 2018/7/15.
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0, n = prices.length;
        int cooldown = 0;
        int sell = 0;
        int diff = -prices[0];
        for (int i = 1; i < n; i++) {
            int temp = cooldown;
            cooldown = Math.max(temp,sell);
            sell = Math.max(sell,prices[i] + diff);
            diff = Math.max(diff, temp - prices[i]);
            max = Math.max(max,cooldown);
            max = Math.max(max,sell);

        }
        return max;
    }
}
