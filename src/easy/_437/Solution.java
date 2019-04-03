package easy._437;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/10/17.
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = helper(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res++;//此处不能return，因为可能出现负数的情况，之后的路径中还能出现不同的路径
        }
        res += helper(root.left, sum - root.val);
        res += helper(root.right, sum - root.val);
        return res;
    }

}
