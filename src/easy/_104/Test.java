package easy._104;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-05.
 */
public class Test {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
