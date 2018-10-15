package easy._653;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/15.
 */
public class Solution {
    /*
     * 这道题我只是想要遍历,dfs做对喽，返回的方式用||的可以解决
     * 改进1：将list改为set，出现一次即可，去掉循环找数
     * 改进2：尝试使用BFS代替DFS，效果没有提升
     * 改进3：利用BST的性质，用中序遍历变成递增序列，然后设置左右指针寻找
     * */
    /*public boolean findTarget(TreeNode root, int k) {
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
    }*/
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
