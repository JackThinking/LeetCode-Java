package hard._72;

/**
 * Created by Citrix on 2018/8/14.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        /*int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                }
            }

        }
        return dp[len1][len2];*/

        int len1 = word1.length();
        int len2 = word2.length();
        int dp[] = new int[len2+1];

        for (int j = 0; j <= len2; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            int prev = i;
            for (int j = 1; j <= len2 ; j++) {
                int cur;
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    cur = dp[j-1];
                }
                else{
                    cur = Math.min(Math.min(dp[j-1],prev),dp[j])+1;
                }
                dp[j-1] = prev;
                prev = cur;

            }
            dp[len2] = prev;
        }
        return dp[len2];


    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(solution.minDistance(word1,word2));
    }
}
