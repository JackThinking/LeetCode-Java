package hard._124;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/7.
 */
public class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathHelper(root);
        return max;
    }

    private int maxPathHelper(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = Math.max(0, maxPathHelper(treeNode.left));
        int right = Math.max(0, maxPathHelper(treeNode.right));
        max = Math.max(max, left + right + treeNode.val);
        return Math.max(left, right) + treeNode.val;


    }
}
