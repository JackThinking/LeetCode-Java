package hard._32;

/**
 * Created by Citrix on 2018/8/14.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int maxVal = 0;
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
             if (s.charAt(i) == ')'){
                 if (s.charAt(i-1) == '('){
                     dp[i] = ((i>=2)?dp[i-2]:0)+2;
                 }
                 else{
                     if (s.charAt(i-1-dp[i-1]) == '(' && i - dp[i - 1] - 1 >= 0){
                         dp[i] = dp[i-1]+dp[i-1-dp[i-1]]+2;
                     }
                 }
             }
            maxVal = Math.max(maxVal,dp[i]);
        }
        return maxVal;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = ")()())";
        System.out.println(solution.longestValidParentheses(test));
    }
}

