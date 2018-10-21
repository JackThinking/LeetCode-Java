package medium._337;

import structure.TreeNode;


/**
 * Created by Citrix on 2018/10/20.
 */
public class Solution {
    /* public int rob(TreeNode root) {
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
     }*/
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(treeNode.left);
        int[] right = dfs(treeNode.right);
        int doit = treeNode.val + left[1] + right[1];
        int notdo = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{doit, notdo};
    }
}
