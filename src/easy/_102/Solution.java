package easy._102;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/9/25.
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        res.get(level).add(node.val);
        helper(res, node.left, level + 1);
        helper(res, node.right, level + 1);
    }


}
