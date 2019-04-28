package easy._112;

import structure.TreeNode;

/**
 * Created by Citrix on 2019-04-10.
 */
public class Test {
    /*
     * 由于只要返回boolean变量，故不需要完整的path中间变量，只要累计值
     * 题目要去是根节点到叶子节点
     * */
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode root, int sum, int tempSum) {
        if (root == null) {
            return false;
        }
        tempSum += root.val;//中间变量的更新放在外面会更好
        if (root.left == null && root.right == null && tempSum == sum) {
            return true;
        }
        return helper(root.left, sum, tempSum) || helper(root.right, sum, tempSum);
    }
}
