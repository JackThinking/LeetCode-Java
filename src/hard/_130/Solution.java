package hard._130;

/**
 * Created by Citrix on 2018/10/4.
 */
/*
 * 这道题用逆向思维做，不能变X就一定要和边缘相连，那可以反过来，先对边缘进行dfs延伸，延伸所到之处赋予特殊符号*
 * 然后再遍历一次的时候就简单了，与O变X，遇*变O。原来的想法是对两种情况进行判别，还要记录坐标，最后还要根据坐标改，麻烦了
 * */
public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
        //从4条边出发进行dfs
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) {
            return;
        }
        if (board[i][j] == 'X'||board[i][j] == '*') {
            return;
        }
        board[i][j] = '*';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);

    }
}
