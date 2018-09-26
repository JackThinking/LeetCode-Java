package easy._98;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/9/24.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        //1.子树与节点大小的比较
        //2.停止条件
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean helper(TreeNode node, long min ,long max){
        if (node == null){
            return true;
        }
        if (node.val>=max || node.val<=min){
            return false;
        }
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);

    }
}
