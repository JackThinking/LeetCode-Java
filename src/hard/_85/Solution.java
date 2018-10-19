package hard._85;


/**
 * Created by Citrix on 2018/10/19.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxsize = 0;
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maxsize = Math.max(maxsize, resize(matrix, i, j));
                }
            }
        }
        return maxsize;
    }

    private int resize(char[][] matrix, int row, int col) {
        int maxsize, size, rowsize;
        /*
         * 是因为判断的时候自己已经判过了，找下面的或者右边的去判断
         * */
        int i = row + 1;
        int j = col + 1;
        maxsize = rowsize = size = 1;//???
        /*
         * 先向下探索,找到最大行
         * */
        while (i < matrix.length && matrix[i++][col] == '1') {
            rowsize++;
        }
        maxsize = size = rowsize;//???
        /*
         * 然后右移到顶部再向下遍历一次，知道遇到‘0’，然后减去走过的面积，当然还可以在开头就设置一下结束条件
         * */
        while (j < matrix[0].length) {
            if (matrix[row][j] == '0') {
                break;
            }
            for (int k = row; k < row + rowsize; k++) {
                if (matrix[k][j] == '0') {
                    int oldsize = rowsize;
                    rowsize = k - row;
                    size -= (j - col) * (oldsize - rowsize);//这不就是K嘛
                }
            }
            size += rowsize;
            maxsize = Math.max(maxsize, size);
            j++;//这边还可以改进吧
        }
        return maxsize;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] map = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalRectangle(map));
    }
}
