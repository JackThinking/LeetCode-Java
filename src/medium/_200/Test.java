package medium._200;

/**
 * Created by Citrix on 2019-04-26.
 */
public class Test {
    int m, n;
    int[][] pat = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    doSearch(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void doSearch(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            for (int i = 0; i < 4; i++) {
                int newx = x + pat[i][0];
                int newy = y + pat[i][1];
                if (inArea(newx, newy)) {
                    doSearch(grid, newx, newy);
                }
            }
        }
    }

    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
