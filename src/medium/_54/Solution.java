package medium._54;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/13.
 */
public class Solution {
    /*
     * 方向，上界，已经访问：何苦用dfs的思路呢，写了while按照4个方向轮流走一边即可，上界更新，初始值为边界
     * */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();//动态添加的数组的话要用arraylist
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (top > bottom || left > right) {
                break;
            }
        }
        return res;
    }
}
