package easy._108;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/9/25.
 */
public class Solution {//中序遍历
    public TreeNode sortedArrayToBST(int[] nums) {
        //1.找中间数
        //2.左右递归
        //3.对于1个数怎么办--这个是难点
        //4.对于2个数怎么办--这个是难点
        if (nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length-1);//取中点自然而然想到要有左右边缘信息
    }
    private TreeNode helper(int[] nums, int low, int high){
        if (low > high){
            return null;
        }
        if (low == high){
            return new TreeNode(nums[low]);
        }
        int mid = low + (high - low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid-1);
        node.right = helper(nums, mid+1, high);
        return node;
    }
}
