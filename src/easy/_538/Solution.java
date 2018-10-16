package easy._538;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    int max = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        max = max + root.val;
        root.val = max;
        convertBST(root.left);
        return root;
    }
}
