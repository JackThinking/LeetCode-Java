package medium._200;

/**
 * Created by Citrix on 2018/9/27.
 */
/*
 * 自己的想法是一个个遍历，是一的话找上下左右，无疑是暴力了，参考答案的dfs法就简单了，将找到的1进行边缘延伸
 * 将其他1都改为0，这样的话减少了不必要的操作。之后好好思考下dfs
 * */
public class Solution {
    int n;
    int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}
