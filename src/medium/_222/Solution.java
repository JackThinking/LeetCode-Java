package medium._222;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/11/18.
 */
public class Solution {
    /*
     * 这道题的初衷是考对于最后的叶子节点进行挨个统计，前面的满的level直接进行累加就行
     * */
    public int countNodes(TreeNode root) {
        int depth = 0;
        int count = 0;
        int sum_depth = 0;
        int sum_count = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }
        for (int i = 0; i < depth; i++) {
            sum_depth += Math.pow(2, i);
        }

        return sum_count + sum_depth;
    }
}
