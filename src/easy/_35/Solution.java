package easy._35;

/**
 * Created by Citrix on 2018/10/18.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target<nums[0]){
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
