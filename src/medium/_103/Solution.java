package medium._103;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/9/26.
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            res.get(level).add(node.val);
        } else {
            res.get(level).add(0, node.val);//偷懒的话用add的额外用法，可以指定插入的序号，一直在0插入的话，相当于数据是逆向存的
        }
        helper(res, node.left, level + 1);
        helper(res, node.right, level + 1);
    }
}
