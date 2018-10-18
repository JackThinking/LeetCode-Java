package medium._114;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/18.
 */
public class Solution {
    /*
    * 类似于链表编制，如果不新建一个的话，就需要先生成一个null,然后倒着开始编制，编制的顺序这边是后序的
    * 这道题还是不熟练
    * */
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
