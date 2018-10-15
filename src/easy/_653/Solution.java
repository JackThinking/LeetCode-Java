package easy._653;

import structure.TreeNode;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Citrix on 2018/10/15.
 */
public class Solution {
    /*
     * 这道题我只是想要遍历,dfs做对喽，返回的方式用||的可以解决
     * 改进1：将list改为set，出现一次即可，去掉循环找数
     * */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
