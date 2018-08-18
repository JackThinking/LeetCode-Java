package medium._287;

/**
 * Created by Citrix on 2018/8/18.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1,right = nums.length-1,mid;
        while(left<=right){
            mid = left + (right-left)/2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]<=mid){
                    count++;
                }
            }
            if (count>mid){
                right = mid - 1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,4,2,2};
        System.out.println(solution.findDuplicate(nums));
    }
}
