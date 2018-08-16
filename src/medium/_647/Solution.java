package medium._647;

/**
 * Created by Citrix on 2018/8/16.
 */
public class Solution {
    int res;
    public int countSubstrings(String s) {
        int[][] memo = new int[s.length()][s.length()];
        helper(s,memo,0,s.length()-1);
        return res;
    }

    public int helper(String s, int[][] memo, int left, int right){

        if (memo[left][right] != 0){
            return memo[left][right];
        }

        if (left == right){
            memo[left][right] = 1;
            res++;
            return memo[left][right];
        }

        if (s.charAt(left) == s.charAt(right)){
            if (left == right-1){
                memo[left][right] = 1;
                res++;
            }
            else{
                if (helper(s,memo,left+1,right-1)!=0){
                    memo[left][right] = 1;
                    res++;
                }
            }

        }
        if (left<s.length()){
            helper(s,memo,left+1,right);
        }
        if (right>0){
            helper(s,memo,left,right-1);
        }
        return memo[left][right];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String nums = "fdsklf";
        System.out.println(solution.countSubstrings(nums));
    }
}
