package easy._101;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/9/24.
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root,root);
    }
    private boolean helper(TreeNode left, TreeNode right){
        if (left == null || right==null){
            return left == right;
        }
        if (left.val != right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
