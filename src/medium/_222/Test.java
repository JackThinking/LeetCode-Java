package medium._222;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-05.
 */
public class Test {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
