package hard._84;

import java.util.Stack;

/**
 * Created by Citrix on 2018/8/15.
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> stack = new Stack<Integer>() ;
        int max = 0;
        for (int i = 0; i < len+1; i++) {
            int h = (i==len?0:height[i]);
            if (stack.isEmpty() || h >= height[stack.peek()]){
                stack.push(i);
            }
            else{
                int top = stack.pop();
                max = Math.max(max,height[top]*((stack.isEmpty())?i:i-1-stack.peek()));
                i--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(nums));
    }
}
