package medium._200;

/**
 * Created by Citrix on 2018/9/27.
 */
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
                    dfsSearch(grid, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void dfsSearch(char[][] grid, int i, int j) {
        if (i >= n || j >= m || i < 0 || j < 0 || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfsSearch(grid, i - 1, j);
        dfsSearch(grid, i + 1, j);
        dfsSearch(grid, i, j - 1);
        dfsSearch(grid, i, j + 1);
    }
}
