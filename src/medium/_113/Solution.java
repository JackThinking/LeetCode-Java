package medium._113;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/10/17.
 */
public class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<Integer> temp = new ArrayList<>();
            helper(root, sum, 0, temp);
            return res;
        }

        private void helper(TreeNode root, int sum, int num, List<Integer> temp) {
            if (root == null) {
                return;
            }
            temp.add(root.val);
            num += root.val;
            if (root.left == null && root.right == null && num == sum) {
                res.add(new ArrayList<Integer>(temp));//一定要new出来才行
                temp.remove(temp.size()-1);
                return;
            }else{
                helper(root.left, sum, num, temp);
                helper(root.right, sum, num, temp);
            }
            temp.remove(temp.size()-1);
        }
}

