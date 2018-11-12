package hard._327;

/**
 * Created by Citrix on 2018/11/12.
 */
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        TreeNode root = new TreeNode(nums[n-1]);
        for (int i = 1; i < n; i++) {
            insertNode(root, nums[i], count, sum, lower, upper);
        }
        return count;
    }

    private void insertNode(TreeNode root, int val, int count, int sum, int lower, int upper) {
        int tempSum = 0;
        while (true) {
            if (val > root.val) {
                if (root.right != null) {
                    root = root.right;
                } else {
                    root.right = new TreeNode(val);
                    break;
                }
            } else {
                if (root.left != null) {
                    root = root.left;
                } else {
                    root.left = new TreeNode(val);
                    break;
                }
            }
        }
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}