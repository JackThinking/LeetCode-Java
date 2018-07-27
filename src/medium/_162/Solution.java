package medium._162;

/**
 * Created by Citrix on 2018/7/27.
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]<nums[mid+1]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
