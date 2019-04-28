package easy._101;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-05.
 */
public class Test {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
