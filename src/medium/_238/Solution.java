package medium._238;

/**
 * Created by Citrix on 2018/10/13.
 */
public class Solution {
    /*
    * 这道题考的是数学原理呀，对于数据的敏感性，有个印象就好
    * */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] = temp * res[i];
            temp = temp * nums[i];
        }
        return res;
    }
}
