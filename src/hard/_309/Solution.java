package hard._309;


import java.net.Socket;

/**
 * Created by Citrix on 2018/7/15.
 */
class Solution {
    /*public int maxProfit(int[] prices) {
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
    }*/
    int[] memo;
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        memo = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            memo[i] = -1;
        }
        return buyAndSell(prices, 0);
    }

    private int buyAndSell(int[] prices, int index) {
        if (index >= prices.length - 1) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }
        int res = 0;
        for (int i = index; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    res = Math.max(res, prices[j] - prices[i] + buyAndSell(prices, j + 2));
                }
            }
        }
        memo[index] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1,2,3,0,2};
        System.out.println(solution.maxProfit(prices));
    }
}
