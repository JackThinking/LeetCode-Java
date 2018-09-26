package easy._104;

import structure.TreeNode;

/**
 * Created by Citrix on 2018/9/24.
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //1.结束条件
        //2.判断最大层级
        //3.计数
        if (root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
