package easy._53;

/**
 * Created by Citrix on 2018/7/5.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int sum_array = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum = Math.max(sum+num, num);
            sum_array = Math.max(sum_array,sum);
        }
        return sum_array;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));
    }
}
