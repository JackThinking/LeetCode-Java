package medium._230;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Citrix on 2018/9/28.
 */
public class Solution {
    /*
     * 第一个想法，先中序遍历得到有序数组，再按照序号取
     * */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res.get(k - 1);
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}
