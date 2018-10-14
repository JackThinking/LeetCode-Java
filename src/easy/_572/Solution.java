package easy._572;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/14.
 */
public class Solution {
    /*
     * 树的相同，不是直接==就解决的，需要写相等判断函数才行
     * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSame(s, t)) {
            return true;
        }
        /*
         * 判断是否相同的话，即可能是左边，也可能是右边的，所以用或
         * */
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        /*
         * 判断相等必须是两边都相等
         * */
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
