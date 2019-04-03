package medium._103;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Citrix on 2018/9/26.
 */
public class Solution {
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root != null) {
            if (level > res.size()) {
                res.add(new ArrayList<>());
            }
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
            helper(res, root.left, level + 1);
            helper(res, root.right, level + 1);
        }
    }*/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean turn = true;
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                if (turn) {
                    list.add(tempNode.val);
                } else {
                    list.add(0, tempNode.val);
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            res.add(list);
            size = queue.size();
            turn = turn ? false : true;
        }
        return res;
    }
}
