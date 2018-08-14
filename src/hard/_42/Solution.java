package hard._42;

/**
 * Created by Citrix on 2018/8/14.
 */
public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];
        left[0]= height[0];
        right[len-1] = height[len-1];
        for (int i = 1; i < len; i++) {
            left[i] = left[i-1]<height[i] ? height[i] : left[i-1];
            right[len-1-i] = height[len-i-1]>right[len-i] ? height[len-i-1] : right[len-i];
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.min(left[i],right[i])-height[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(nums));
    }
}
