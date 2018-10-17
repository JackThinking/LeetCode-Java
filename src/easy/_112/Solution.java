package easy._112;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/17.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int temp) {
        if (root == null) {
            return false;
        }
        temp += root.val;
        if (root.left == null && root.right == null && temp == sum) {
            return true;
        }
        return helper(root.left, sum, temp) || helper(root.right, sum, temp);
    }
}
