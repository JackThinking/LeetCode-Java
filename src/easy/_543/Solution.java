package easy._543;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/16.
 */
public class Solution {
    int maxNum = 0;//返回的数据与要获取的数据不是一种格式，就把它提到外面来

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);//并不是之后void形的函数才能这样空执行的
        return maxNum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        maxNum = Math.max(maxNum, left + right);
        return Math.max(left, right) + 1;
    }
}
