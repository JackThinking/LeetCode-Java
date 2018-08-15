package medium._64;

/**
 * Created by Citrix on 2018/8/15.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        /*int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];
        dp[0][0] = grid[0][0];

        if (row == 1){
            int temp = 0;
            for (int i = 0; i < col; i++) {
                temp += grid[0][i];
            }
            return temp;
        }

        if (col == 1){
            int temp = 0;
            for (int i = 0; i < row; i++) {
                temp += grid[i][0];
            }
            return temp;
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
            for (int j = 1; j < col; j++) {
                dp[0][j] = dp[0][j-1]+grid[0][j];
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[row-1][col-1];*/
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        return helper(grid,memo,row-1,col-1);
    }

    public int helper(int[][] grid, int[][] memo, int x, int y){
        if (x==0 && y==0){
            return grid[0][0];
        }
        if (memo[x][y] != 0){
            return memo[x][y];
        }

        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if (y>0){
            up = helper(grid,memo,x,y-1);
        }
        if (x>0){
            left = helper(grid,memo,x-1,y);
        }

        int dist = grid[x][y]+Math.min(left,up);
        memo[x][y] = dist;
        return dist;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        int[][] nums = {{0,1},{1,0}};
        System.out.println(solution.minPathSum(nums));
    }
}
