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
        return helper(nums, 0, nums.length-1);//这边的确就直接return结果就好
    }
    private TreeNode helper(int[] nums, int left, int right){
        if (left>right){
            return null;
        }//分开考虑会更好
        if (left == right){
            return new TreeNode(nums[left])
        }
        //取中点的时候注意公式
        int mid = left + (right-left)/2;
        TreeNode newnode = new TreeNode(nums[mid]);
        newnode.left = helper(nums, left, mid-1);
        newnode.right = helper(nums, mid+1, right);
        return  newnode;
    }
}
