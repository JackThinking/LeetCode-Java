package hard._72;

/**
 * Created by Citrix on 2019-05-11.
 */
public class Test {
    public int minDistance(String word1, String word2) {
        char[] array1 = word1.toCharArray();
        char[] array2 = word2.toCharArray();
        int row = array1.length + 1;
        int col = array2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
            }
        }
        return dp[row - 1][col - 1];
    }
}
