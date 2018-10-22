package hard._221;

/**
 * Created by Citrix on 2018/10/22.
 */
public class Solution {
    private int max = 0;

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        /*
        * 自己做的时候想到了可能会需要重复判断，加一个备忘录不就行了嘛，死脑筋
        * */
        boolean[][] visited = new boolean[rows][cols];
        dfs(matrix, visited, 0, 0);
        return max * max;
    }

    private void dfs(char[][] matrix, boolean[][] visited, int row, int col) {
        if (row + max >= matrix.length || col + max >= matrix[0].length || visited[row][col] == true) {
            return;
        }
        visited[row][col] = true;
        if (matrix[row][col] == '1') {
            /*
             * 1.查看位
             * */
            while (isValid(matrix, row, col)) {
                max++;
            }
        }
        dfs(matrix, visited, row + 1, col);
        dfs(matrix, visited, row, col + 1);
    }

    private boolean isValid(char[][] matrix, int row, int col) {
        if (row + max >= matrix.length || col + max >= matrix[0].length) {
            return false;
        }
        /*
        * 如何跳出双for循环，这个提供了一个好的想法
        * */
        boolean isValid = true;
        for (int i = row; i <= row + max; i++) {
            for (int j = col; j <= col + max; j++) {
                if (matrix[i][j] == '0') {
                    isValid = false;
                    break;
                }
            }
            if (isValid == false) {
                break;
            }
        }
        return isValid;
    }
}
