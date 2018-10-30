package hard._10;

/**
 * Created by Citrix on 2018/10/30.
 */
public class Solution {
    /*
    * 还要再理解一下子
    * */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[ s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        /*
         * 大概意思是开头有*的话，都可以去掉，等于没有*号
         * */
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) == '*' && p.charAt(i - 1) != '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*' && j > 0 && p.charAt(j - 1) != '*') {
                    /*
                     * 需要将*当做0对待了
                     * */
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
