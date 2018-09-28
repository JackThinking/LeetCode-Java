package medium._116;

import structure.TreeLinkNode;

/**
 * Created by Citrix on 2018/9/28.
 */
//你看看，自己多思考也能做出来的
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }

    private void helper(TreeLinkNode root) {
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
