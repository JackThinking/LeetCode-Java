package medium._714;

/**
 * Created by Citrix on 2018/8/10.
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int n = prices.length;
        int hold = -prices[0];
        int nothold = 0;

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold,nothold-prices[i]);
            nothold = Math.max(nothold,hold-fee+prices[i]);
        }
        return nothold;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 2, 8, 4, 9};
        System.out.println(solution.maxProfit(nums,2));
    }
}
