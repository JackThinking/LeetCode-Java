package medium._581;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    /*
     * 要重新写，逻辑不清晰
     * */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int begin = -1;
        int end = -2;
        int max = nums[0];
        int min = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);//左边的最大值
            min = Math.min(min, nums[n - 1 - i]);//右边开始的最小值
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - i - 1] > min) {
                begin = n - 1 - i;
            }
        }
        return end - begin + 1;
    }
}
