package hard._124;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/7.
 */
public class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }//树的一般返回
        int left = Math.max(0, maxPathDown(node.left));//左右遍历
        int right = Math.max(0, maxPathDown(node.right));
        max = Math.max(max, left + right + node.val);//记录最大值
        return Math.max(left, right) + node.val;//这个一般的返回有点难理解，是因为返回的时候去掉所有负数，由于前面left,right已经与0比较过了，所以去他们之中的最大值即可
    }
}
