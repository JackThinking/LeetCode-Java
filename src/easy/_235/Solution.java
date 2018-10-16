package easy._235;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }*/
        while (root.val > Math.max(p.val, q.val) || root.val < Math.min(p.val, q.val)) {
            if (root.val > p.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
