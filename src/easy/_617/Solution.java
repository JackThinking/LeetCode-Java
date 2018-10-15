package easy._617;
import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/14.
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }

    private TreeNode helper(TreeNode t1, TreeNode t2) {
        TreeNode node = null;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            node = new TreeNode(t1.val + t2.val);
            node.left = helper(t1.left, t2.left);
            node.right = helper(t1.right, t2.right);
        } else if (t1 == null && t2 != null) {
            node = t2;
        } else {
            node = t1;
        }
        return node;
    }
}