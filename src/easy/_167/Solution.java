package easy._167;

/**
 * Created by Citrix on 2018/10/15.
 */
public class Solution {
    /*
    * 就是下午做的树形状Sum的简化版，对于有序数组的运用只是，用首尾相加来判定指针的移动，其实感觉可以加入二分
    * */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{l + 1, r + 1};
    }
}
