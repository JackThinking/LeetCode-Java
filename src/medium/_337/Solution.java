package medium._337;

import structure.TreeNode;

import java.util.Map;


/**
 * Created by Citrix on 2018/10/20.
 */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(robNow(root), robNext(root));
    }

    public int robNow(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + robNext(root.left) + robNext(root.right);
    }

    public int robNext(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rob(root.left) + rob(root.right);
    }
}
