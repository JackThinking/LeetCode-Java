package easy._100;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/18.
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helper(p, q);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        /*
        * 这种双节点的结束方式不是第一次见了，要完全相同才能正确执行
        * */
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return helper(p.left, q.left) && helper(p.right, q.right);
        } else {
            return false;
        }
    }

}
