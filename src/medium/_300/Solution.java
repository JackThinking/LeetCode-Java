package medium._300;

import java.util.Arrays;

/**
 * Created by Citrix on 2018/7/9.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] tail = new int[len];
        int size = 0;
        for (int num:nums) {
            int i = 0,j = size;
            while(i!=j){//这边居然是不等于？？？
                int m = i + (j-i)/2;
                if (num>tail[m]){
                    i = m+1;
                }
                else{
                    j = m;
                }
            }
            tail[i] = num;
            if (size == i) size++;
        }
        return size;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
