package medium._33;

/**
 * Created by Citrix on 2018/9/5.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left<=right){
            int mid = left+(right-left)/2;
            /*
            * 找到了就返回坐标
            * */
            if (nums[mid]==target){
                return mid;
            }

            /*
            * 大于左边的话，说明左边序列一定是递增的
            * */
            if (nums[mid]>=nums[left]){
                /*
                * 接着判断目标值是不是在递增区间之内
                * */
                if (target>nums[left]&&target<nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if (target>nums[mid]&&target<nums[right]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
