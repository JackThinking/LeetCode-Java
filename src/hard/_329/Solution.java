package hard._329;

/**
 * Created by Citrix on 2018/10/12.
 */
public class Solution {
    int m;
    int n;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        if (m == 0) {
            return 0;
        }
        n = matrix[0].length;
        int max = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, cache, Integer.MIN_VALUE);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache, int pre) {
        /*
         * 将大小判断移到这边的终止条件上来了
         * */
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= pre) {
            return 0;
        }
        /*
         * 这一部分是之前考虑不周全的，就是缓存的值，这个其实和动态规划也很想
         * */
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(dfs(matrix, i - 1, j, cache, cur), tempMax);
            tempMax = Math.max(dfs(matrix, i, j - 1, cache, cur), tempMax);
            tempMax = Math.max(dfs(matrix, i + 1, j, cache, cur), tempMax);
            tempMax = Math.max(dfs(matrix, i, j + 1, cache, cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{3, 4, 5},{3, 2, 6},{2, 2, 1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
