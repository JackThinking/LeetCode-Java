package medium._105;

import structure.TreeNode;

import java.util.Arrays;

/**
 * Created by Citrix on 2018/9/27.
 */
public class Solution {//不过这次思路正确了
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);//卡在了数组下标的思考上，其实直接把这些信息放到helper函数也行
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {//这个结束条件没有想到
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {//过于依赖函数，没有安全感的体现
            if (inorder[i] == node.val) {
                inIndex = i;
            }
        }
        node.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        node.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        return node;
    }
}
