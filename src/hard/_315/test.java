package hard._315;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Citrix on 2018/10/23.
 */
public class test {
    /*
    * 这道题是二叉搜索树的题目，要反过来插入才能想到，周末对二叉搜索树的API好好理解
    * */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        TreeNode root = new TreeNode(nums[n - 1]);
        res.add(0);
        for (int i = n - 2; i >= 0; i--) {
            int tempcount = insertNode(root, nums[i]);
            res.add(tempcount);
        }
        Collections.reverse(res);
        return res;
    }

    private int insertNode(TreeNode root, int val) {
        int rescount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;//这个count花了点时间理解
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                rescount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;//这个break没想到
                } else {
                    root = root.right;
                }
            }
        }
        return rescount;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    int count = 1;

    public TreeNode(int val) {
        this.val = val;
    }
}
