package hard._152;

/**
 * Created by Citrix on 2018/7/10.
 */
public class Solution {
    /*
     * 2钟情况考虑，一种是来的值比之前的都大了，还有一种是正负数的变换
     * */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxVal = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            maxVal = Math.max(maxVal, max[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }
}
