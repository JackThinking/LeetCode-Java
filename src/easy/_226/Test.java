package easy._226;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-05.
 */
public class Test {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
