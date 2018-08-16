package medium._647;

/**
 * Created by Citrix on 2018/8/16.
 */
public class Solution {
    /*int res;
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
        return memo[left][right];*/

    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
             int t1 = search(s,i,i);
             int t2 = search(s,i,i+1);
             sum += t1+t2;
        }
        return sum;
    }

    public int search(String s, int left ,int right){
        int tempsum = 0;
        while(left>0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            tempsum++;
        }
        return tempsum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String nums = "fdsklf";
        System.out.println(solution.countSubstrings(nums));
    }
}
