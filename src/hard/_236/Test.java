package hard._236;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-03.
 */
public class Test {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else {
            return left != null ? left : right;
        }
    }
}
