package hard._152;

/**
 * Created by Citrix on 2018/7/10.
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] maxdp = new int[n+1];
        int[] mindp = new int[n+1];
        int maxVal = Integer.MIN_VALUE;
        maxdp[0] = 1;
        mindp[0] = 1;
        for (int i = 1; i < n+1; i++) {
            maxdp[i] = Math.max(maxdp[i-1]*nums[i-1], Math.max(mindp[i-1]*nums[i-1], nums[i-1]));
            mindp[i] = Math.min(mindp[i-1]*nums[i-1], Math.min(maxdp[i-1]*nums[i-1], nums[i-1]));
            maxVal = Math.max(maxVal, maxdp[i]);
        }
        return maxVal;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,3,-2,4};
        System.out.println(solution.maxProduct(nums));
    }
}
