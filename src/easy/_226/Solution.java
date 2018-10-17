package easy._226;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/17.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return helper(root);
    }

    private TreeNode helper(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = helper(treeNode.right);
        treeNode.right = helper(temp);
        return treeNode;
    }
}
