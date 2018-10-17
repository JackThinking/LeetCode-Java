package easy._437;

import com.sun.tools.corba.se.idl.InterfaceGen;
import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Citrix on 2018/10/17.
 */
public class Solution {
    int res = 0;
    Map<Integer, Integer> map;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        map = new HashMap<>();
        map.put(0, 1);
        helper(root, sum, 0);
        return res;
    }

    private void helper(TreeNode root, int sum, int tempSum) {
        if (root == null) {
            return;
        }
        tempSum += root.val;
        res += map.getOrDefault(tempSum - sum, 0);//??????
        map.put(tempSum, map.getOrDefault(tempSum, 0) + 1);
        helper(root.left, sum, tempSum);
        helper(root.right, sum, tempSum);
        map.put(tempSum, map.get(tempSum) - 1);//?????????

    }

}
