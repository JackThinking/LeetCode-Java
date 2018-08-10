package medium._11;

/**
 * Created by Citrix on 2018/8/10.
 */
public class Solution {
    public int maxArea(int[] height) {
        /*int len = height.length;
        int sum = 0;
        int left = 0;
        int right = len-1;
        while(left<=right){
            int tempsum;
            if (height[left]<=height[right]){
                tempsum = (right-left)*height[left];
                left++;
            }
            else{
                tempsum = (right-left)*height[right];
                right--;
            }
            sum = Math.max(sum,tempsum);
        }
        return sum;*/
        int len = height.length;
        int left = 0,right = len - 1,max = 0;
        while(left<right){
            int h = Math.min(height[left],height[right]);
            max = Math.max(max,h*(right-left));
            while(left<right && height[left]<=h){
                left++;
            }
            while(left<right && height[right]<=h){
                right--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(nums));
    }
}

