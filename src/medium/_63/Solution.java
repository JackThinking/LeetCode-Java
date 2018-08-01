package medium._63;

/**
 * Created by Citrix on 2018/8/1.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;//列的个数
        int n = obstacleGrid[0].length;//行的个数
        int[][] sum = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            else{
                sum[0][i] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            else{
                sum[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1){
                    sum[i][j] = 0;
                }
                else{
                    sum[i][j] = sum[i-1][j]+sum[i][j-1];
                }

            }
        }
        return sum[m-1][n-1];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1,0}};
        System.out.println(solution.uniquePathsWithObstacles(nums));
    }
}

