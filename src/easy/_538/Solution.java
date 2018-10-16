package easy._538;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    int max = 0;

    /*
    * 思路正确，执行没有经验，首先确认是后序遍历执行，然后不需要重新构建树，只需要将root.val值重新赋值即可
    * 这种重新赋值构建树的话，return的是节点本身
    * */
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
