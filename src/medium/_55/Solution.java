package medium._55;

/**
 * Created by Citrix on 2018/7/6.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int curr = nums.length;
        for (int i = curr-2; i >= 0; i--) {
            if (nums[i] == 0){
                int jump = 1;
                while(nums[i] < jump){
                    i--;
                    jump++;
                    if(i<0){
                        return false;
                    }
                }
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }
}
