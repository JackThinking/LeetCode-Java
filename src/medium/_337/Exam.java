package medium._337;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-03-03.
 */
public class Exam {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(robNow(root), robNext(root));
    }

    private int robNext(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }

    private int robNow(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + robNext(root.left) + robNext(root.right);
    }
}
