package medium._105;

import structure.TreeNode;


/**
 * Created by Citrix on 2018/9/27.
 */
public class Solution {//不过这次思路正确了

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //主要是对于两个数组的重新排列，要注意的是其中有一个步骤是在inorder中找到preorder的序号
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (node.val == inorder[i]) {
                inIndex = i;
            }
        }
        node.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        node.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);
        return node;
    }

}
