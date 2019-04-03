package easy._257;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2019-04-02.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, res, "");
        return res;
    }

    private void helper(TreeNode root, List<String> res, String string) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(string + root.val);
            return;
        }
        helper(root.left, res, string + root.val + "->");
        helper(root.right, res, string + root.val + "->");
    }
}
