package medium._94;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** Created by Citrix on 2018/9/26. */
public class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    helper(res, root);
    return res; // 将helper函数设置成void,在参数表中加入答案res,这种方式遇到两次了，与其他对比一下
  }

  private void helper(List<Integer> res, TreeNode node) {
    if (node != null) {
      helper(res, node.left);
      res.add(node.val);
      helper(res, node.right);
    }
  }
}
