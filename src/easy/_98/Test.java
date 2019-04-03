package easy._98;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-02.
 */
public class Test {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val >= maxValue || root.val <= minValue) {
            return false;
        }
        return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
    }
}
