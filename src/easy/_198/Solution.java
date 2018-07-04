package easy._198;

/**
 * Created by Citrix on 2018/7/4.
 */
public class Solution {
    /*public int rob(int[] nums) {
        int length = nums.length;
        int[] money = new int[length];
        if (length == 0){
            return 0;
        }
        if (length < 2){
            return nums[0];
        }
        money[0] = nums[0];
        money[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < money.length; i++) {
            money[i] = Math.max(nums[i]+money[i-2],money[i-1]);
        }
        return money[length-1];
        }
        */

        public int rob(int[] nums) {
            int prev = 0, curr = 0;
            for (int n : nums) {
                int tmp = curr;
                curr = Math.max(prev + n, curr);
                prev = tmp;
            }
            return curr;
        }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(solution.rob(nums));
    }
}
