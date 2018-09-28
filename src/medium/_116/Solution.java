package medium._116;

import structure.TreeLinkNode;

/**
 * Created by Citrix on 2018/9/28.
 */
//你看看，自己多思考也能做出来的；之后用堆栈的方式再做
public class Solution {
    /*public void connect(TreeLinkNode root) {
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
    }*/
    /*
     * 单层连接移动,这个是自己没有想到的，感觉有点像BFS，自己的做法像DFS，巧的是判断逻辑基本上是一样的
     * */
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
}
