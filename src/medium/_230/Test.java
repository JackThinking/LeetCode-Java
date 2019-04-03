package medium._230;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-03.
 */
public class Test {
    /*
     * 二叉树的思想，左子树的个数+1就是该节点的排序
     * */
    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);
        } else if (k < count + 1) {
            return kthSmallest(root.left, k);
        } else {
            return root.val;
        }
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
}
