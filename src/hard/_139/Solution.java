package hard._139;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Citrix on 2018/7/14.
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        int longestLen = 0;
        for (String word : wordDict) {
            if (word.length() > longestLen) {
                longestLen = word.length();
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= longestLen; j++) {
                if (i>=j && dp[i-j]==true && wordDict.contains(s.substring(i-j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "pineapplepenapple";
        List<String> word = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(solution.wordBreak(s,word));
    }

}
