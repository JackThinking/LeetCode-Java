package medium._240;

/**
 * Created by Citrix on 2018/11/18.
 */
public class Solution {
    /*
    * 与第一题不同的是，这一题并不是上一行的末尾与下一行到首部有大小顺序，而是分开有顺序，但是这样有个性质就是
    * 从右上角看的话，其实就是严格的二叉树，其代码和第一题相差又不多了
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            int num = matrix[row][col];
            if (num == target) return true;
            /*
            * 这个地方居然搞错了
            * */
            if (num > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
