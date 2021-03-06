package medium._300;


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
            while(i<j){//考虑一下，while取等号，-1+1的区分
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
        int[] nums = {10,9,2,5,7,3,101,18};
        System.out.println(solution.lengthOfLIS(nums));
    }
}
