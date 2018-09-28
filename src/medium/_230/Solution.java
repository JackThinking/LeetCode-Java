package medium._230;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Citrix on 2018/9/28.
 */
public class Solution {
    /*
     * 第一个想法，先中序遍历得到有序数组，再按照序号取
     * */
    /*public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res.get(k - 1);
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }*/
    /*
     * 其实不用完全排序，只要知道所求的index与该节点的index的大小关系，即可进行优化
     * */
    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if (k > count + 1) {
            return kthSmallest(root.right, k - count - 1);//对于大小的判断不够熟练，不是void的话，要return的！！！
        } else if (k <= count) {
            return kthSmallest(root.left, k);
        }
        return root.val;//就是当k=count+1的时候，结束递归
    }

    private int count(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }
}
